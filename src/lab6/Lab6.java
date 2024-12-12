package lab6;

import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import common.IRunnable;
import common.InputValidator;
import lab6.annotations.*;

public class Lab6 implements IRunnable {

    private static PrintStream out = System.out;

    @Override
    public void run() {
        loopTasks();
    }

    private void loopTasks() {
        var exitRequested = false;

        listTasks();
        while (!exitRequested) {
            out.println("\nВведите номер задания (введите 0 для выхода):");
            var taskNum = InputValidator.readInt(true);

            switch (taskNum) {
                case 1: runTask1(); break;
                case 2: runTask2(); break;
                default: out.print("Задания с таким номером нет. ");
            }
        }
    }
    
    private void runTask1() {
        ForCaching cachedObj = CacheUtil.cache(new SampleClass("first"));

        out.println("Первый вызов метода, результат будет вычислен");
        out.println(cachedObj.cacheTest());

        cachedObj.setStringField("second");

        out.println("Метод снова вызовется, так как объект изменился");
        out.println(cachedObj.cacheTest());

        out.println("Метод не будет повторно вызываться, если состояние объекта не изменилось");
        out.println(cachedObj.cacheTest());
    }        
    
    private void runTask2() {
        showAnnotations(InvokeSample.class);
        showAnnotations(DefaultSample.class);
        showAnnotations(ToStringSample.class);
        showAnnotations(ValidateSample.class);
        showAnnotations(TwoSample.class);
        showAnnotations(CacheSample.class);
    }

    public static void showAnnotations(Class<?> clazz) {
        System.out.println("Аннотации в классе: " + clazz.getSimpleName());
        
        for (var annotation : clazz.getAnnotations()) {
            System.out.println(getAnnotationName(annotation));
        }
        
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("\nМетод: " + method.getName());
            for (var annotation : method.getAnnotations()) {
                System.out.println(getAnnotationName(annotation));
            }
        }
        
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("\nПоле: " + field.getName());
            for (var annotation : field.getAnnotations()) {
                System.out.println(getAnnotationName(annotation));
            }
        }
        
        System.out.println("\n-----------------------------------\n");
    }

    private static String getAnnotationName(Annotation annotation) {
        var fullName = annotation.annotationType().getName().split("\\.");
        var name = fullName[fullName.length - 1];

        return name;
    }

    private void runTask3() {
        out.println("404. Проверка в тестах");
    }

    private void runTask4() {
        out.println("404. Nothing to see here");
    }

    private void listTasks() {
        out.println("1. Рефлексия. Кэширование");
        out.println("2. Аннотации");
        out.println("3. Обработка аннотаций. Кэширование.");
        out.println("4. Тестирование");
    }

}
