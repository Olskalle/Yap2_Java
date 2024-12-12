package lab6.tests;

import lab6.ModifiedCacheUtil;
import lab6.annotations.Cache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CacheUtilTest {

    // Создаем объект с аннотацией @Cache
    @Cache(value = {"cacheTest"})
    static class TestClass {
        private String stringField;

        public TestClass(String value) {
            stringField = value;
        }

        public int cacheTest() {
            System.out.println("original method");
            return 42;
        }

        public void setStringField(String value) {
            this.stringField = value;
        }
    }

    // Создаем объект без аннотации @Cache
    static class NonCacheClass {
        private String stringField;

        public NonCacheClass(String value) {
            stringField = value;
        }

        public int cacheTest() {
            return 42;
        }
    }

    private TestClass testObject;
    private NonCacheClass nonCacheObject;

    @BeforeEach
    void setUp() {
        testObject = new TestClass("first");
        nonCacheObject = new NonCacheClass("first");
    }

    @Test
    void testCacheWithAnnotatedObject() {
        // Проксимируем объект с аннотацией @Cache
        Object[] proxies = ModifiedCacheUtil.cache(testObject);

        // Получаем проксированный объект
        TestClass cachedObject = (TestClass) proxies[0];

        // Вызываем метод cacheTest(), он должен вернуть 42 и вывести "original method"
        System.out.println("Первый вызов метода — результат будет вычислен");
        assertEquals(42, cachedObject.cacheTest()); // Ожидаем, что метод вернет 42

        // Изменяем состояние объекта
        cachedObject.setStringField("second");

        // Повторный вызов, метод должен вернуть 42 и снова вывести "original method"
        System.out.println("Метод снова вызовется, так как объект изменился");
        assertEquals(42, cachedObject.cacheTest()); // Ожидаем, что метод вернет 42

        // Повторный вызов без изменений, результат должен быть из кэша
        System.out.println("Метод не будет повторно вызываться, если состояние объекта не изменилось");
        assertEquals(42, cachedObject.cacheTest()); // Ожидаем, что метод вернет 42, так как результат закеширован
    }

    @Test
    void testCacheWithNonAnnotatedObject() {
        // Проксимируем объект без аннотации @Cache
        Object[] proxies = ModifiedCacheUtil.cache(nonCacheObject);

        // Проверяем, что объект без аннотации @Cache не был проксирован
        assertEquals(nonCacheObject, proxies[0]); // Ожидаем, что вернется сам объект, а не прокси
    }

    @Test
    void testCacheWithMultipleObjects() {
        // Проксимируем несколько объектов (один с аннотацией, другой без)
        Object[] proxies = ModifiedCacheUtil.cache(testObject, nonCacheObject);

        // Проверяем, что первый объект — это прокси
        TestClass cachedObject = (TestClass) proxies[0];
        assertNotEquals(testObject, cachedObject); // Ожидаем, что это будет проксированный объект

        // Проверяем, что второй объект не был проксирован
        assertEquals(nonCacheObject, proxies[1]); // Ожидаем, что второй объект — это оригинальный объект
    }
}

