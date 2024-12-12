package lab6;
import java.lang.reflect.*;
import java.util.*;

public class CacheUtil {

    @SuppressWarnings("unchecked")
    public static <T> T cache(T object) {
        // Проверяем, является ли объект интерфейсом или классом
        Class<?> clazz = object.getClass();
        
        // Создаем прокси для интерфейсов или классов
        return (T) Proxy.newProxyInstance(
            clazz.getClassLoader(),
            clazz.getInterfaces(),
            new MethodInterceptor<>(object)
        );
    }

    private static class MethodInterceptor<T> implements InvocationHandler {
        private final T target;
        private final Map<Method, Object> cache = new HashMap<>();
        private final Map<Method, Object> lastState = new HashMap<>();

        public MethodInterceptor(T target) {
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
