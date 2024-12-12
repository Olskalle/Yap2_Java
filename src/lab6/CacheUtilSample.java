package lab6;

import lab6.annotations.Cache;

@Cache(value = {"cacheTest", "anotherTest"})
public class CacheUtilSample {
    private int count = 0;

    public int cacheTest() {
        count++;
        System.out.println("Executing cacheTest, count = " + count);
        return count;
    }

    public String anotherTest() {
        System.out.println("Executing anotherTest");
        return "Hello";
    }

    public String notCachedTest() {
        System.out.println("Executing notCachedTest");
        return "Not cached";
    }
}