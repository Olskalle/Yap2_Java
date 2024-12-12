package lab6;
import java.lang.reflect.*;
import java.util.*;

import lab6.annotations.Cache;

public class ModifiedCacheUtil {

    public static Object[] cache(Object... objects) {
        List<Object> proxies = new ArrayList<>();

        for (Object object : objects) {
            // Проверяем наличие @Cache
            Cache cacheAnnotation = object.getClass().getAnnotation(Cache.class);
            
            if (cacheAnnotation != null) {
                // Создаем прокси для объектов с аннотацией @Cache
                Object proxy = Proxy.newProxyInstance(
                    object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(),
                    new MethodInterceptor<>(object, cacheAnnotation.value())
                );

                proxies.add(proxy);
            }
        }

        return proxies.toArray();
    }


    private static class MethodInterceptor<T> implements InvocationHandler {
        private final T target;
        private final Map<Method, Object> cache = new HashMap<>();
        private final Map<Method, Object> lastState = new HashMap<>();

        public MethodInterceptor(T target, String[] methodsToCache) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Просто вызываем метод с параметрами
            if (method.getParameterCount() > 0) {
                return method.invoke(target, args);
            }

            // Проверяем кэш
            if (cache.containsKey(method)) {

                // Если объект изменился, повторно вызываем метод и обновляем кэш
                Object currentState = getState(target);
                if (lastState.containsKey(method) && !lastState.get(method).equals(currentState)) {
                    Object result = method.invoke(target);
                    cache.put(method, result);
                    lastState.put(method, currentState);
                    return result;
                }

                // Возвращаем кэшированное значение
                return cache.get(method);
            }

            // Если метод вызывается первый раз, просто вызываем его
            Object result = method.invoke(target);
            cache.put(method, result);
            lastState.put(method, getState(target));
            return result;
        }

        // Получение состояния объекта
        private Object getState(T target) {
            try {
                Field[] fields = target.getClass().getDeclaredFields();
                Map<String, Object> state = new HashMap<>();
                for (Field field : fields) {
                    field.setAccessible(true);
                    state.put(field.getName(), field.get(target));
                }
                return state;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Ошибка получения состояния", e);
            }
        }
    }
}
