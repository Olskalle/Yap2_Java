package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import common.IRunnable;
import common.InputValidator;

public class Lab4 implements IRunnable {

    public void run() {
        loopTasks();
    }

    private void loopTasks() {
        var exitRequested = false;

        listTasks();
        while (!exitRequested) {
            System.out.println("\nВведите номер задания (введите 0 для выхода):");
            var taskNum = InputValidator.readInt(true);

            switch (taskNum) {
                case 0:
                    exitRequested = true;
                    System.out.println("Выход...");
                    break;
                case 12:
                    runTask12();
                    break;
                case 15:
                    runTask15();
                    break;
                case 2:
                    runTask2();
                    break;
                case 31:
                    runTask31();
                    break;
                case 32:
                    runTask32();
                    break;
                case 33:
                    runTask33();
                    break;
                case 34:
                    runTask34();
                    break;

                default:
                    System.out.print("Задания с таким номером нет. ");
            }
        }
    }

    private void runTask12() {
        System.out.println("Хранилище для чисел с null");
        Storage<Integer> numberStorage1 = new Storage<>(null);
        System.out.println("Значение: " + numberStorage1.getValueOrAlternative(0));

        System.out.println("Хранилище для чисел с 99");
        Storage<Integer> numberStorage2 = new Storage<>(99);
        System.out.println("Значение: " + numberStorage2.getValueOrAlternative(-1));

        System.out.println("Хранилище для строк с null");
        Storage<String> stringStorage1 = new Storage<>(null);
        System.out.println("Значение: " + stringStorage1.getValueOrAlternative("default"));

        System.out.println("Хранилище для строк с \"hello\"");
        Storage<String> stringStorage2 = new Storage<>("hello");
        System.out.println("Значение: " + stringStorage2.getValueOrAlternative("default"));
    }

    private void runTask15() {
        System.out.println("Линия в 3D пространстве");
       
        System.out.println("Введите координаты первой трехмерной точки по очереди.");
        var start = new Point3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false));
        
            System.out.println("Введите координаты второй трехмерной точки по очереди.");
        var end = new Point3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false));
        
        Line<Point3d> line3d = new Line<>(start, end);
        System.out.println(line3d);
    }

    private void runTask2() {
        System.out.println("Сдвинем линию.");
        var start = new Point3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false));
        
            System.out.println("Введите координаты второй трехмерной точки по очереди.");
        var end = new Point3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false));
        
        Line<Point3d> line3d = new Line<>(start, end);
        System.out.println("Изначально: " + line3d); 
        
        line3d.moveStartX(10);
        System.out.println("Сдвинутая линия (точка начала сдвинута на 10 по Х) : " + line3d);
    }

    private void runTask31() {
        System.out.println("1. Длины строк");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Строки:" + strings);

        List<Integer> lengths = GenericMethods.apply(strings, s -> s.length());
        System.out.println("Длины строк: " + lengths);

        System.out.println("2. Преобразование отрицательных чисел");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        System.out.println("Числа: " + numbers);

        List<Integer> absoluteValues = GenericMethods.apply(numbers, n -> Math.abs(n));
        System.out.println("Преобразованные в неотрицательные числа: " + absoluteValues);

        System.out.println("3. Максимальные значения в массивах");
        List<int[]> arrays = Arrays.asList(new int[]{1, 3, 7}, new int[]{-1, -5, 2});
        System.out.println("Список масивов: ");
        arrays.forEach(array -> System.out.println(Arrays.toString(array)));
        
        List<Integer> maxValues = GenericMethods.apply(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));
        System.out.println("Максимальные значения: " + maxValues);
    }

    private void runTask32() {
        System.out.println("1. Фильтрация строк по длине");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Строки:" + strings);

        List<String> filteredStrings = Filter.filter(strings, s -> s.length() >= 3);
        System.out.println("Отфильтрованные строки" + filteredStrings);

        System.out.println("2. Фильтрация отрицательных чисел");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        System.out.println("Числа: " + numbers);

        List<Integer> negativeNumbers = Filter.filter(numbers, n -> n < 0);
        System.out.println("Без положительных: " + negativeNumbers);

        System.out.println("3. Фильтрация массивов без положительных элементов");
        List<int[]> arrays = Arrays.asList(new int[]{1, 3, 7}, new int[]{-1, -5, -2});
        System.out.println("Список масивов: ");
        arrays.forEach(array -> System.out.println(Arrays.toString(array)));
        
        List<int[]> noPositiveArrays = Filter.filter(arrays, arr -> Arrays.stream(arr).noneMatch(n -> n > 0));
        System.out.println("Массивы без положительных чисел: ");
        noPositiveArrays.forEach(array -> System.out.println(Arrays.toString(array)));
    }

    private void runTask33() {
        System.out.println("1. Слияние строк");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Строки:" + strings);

        String concatenated = GenericMethods.reduce(strings, (s1, s2) -> s1 + s2, "");
        System.out.println("Итоговая строка: " + concatenated);

        System.out.println("2. Сумма чисел");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        System.out.println("Числа: " + numbers);
        
        int sum = GenericMethods.reduce(numbers, (n1, n2) -> n1 + n2, 0);
        System.out.println("Сумма: " + sum);
        
        System.out.println("2. Общее кол-во элементов");
        List<List<Integer>> listOfLists = List.of(
            new ArrayList<>(List.of(1, 2, 3)),
            new ArrayList<>(List.of(4, 5)),
            new ArrayList<>(List.of(6, 7, 8, 9))
        );
        
        List<Integer> totalBySublists = GenericMethods.reduce(listOfLists, (acc, currentList) -> {
            acc.addAll(currentList);
            return acc;
            }, new ArrayList<>());
            
        int totalCount = GenericMethods.reduce(totalBySublists, (n1, n2) -> n1 + 1, 0);

        System.out.println("Общее количество элементов: " + totalCount);

        List<Integer> empty = List.of(); 
        int emptyTest = GenericMethods.reduce(empty, (n1, n2) -> n1 + n2, 0);
    }

    private void runTask34() {
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> positiveNumbers = GenericMethods.processCollection(
                numbers,
                ArrayList::new,
                num -> num > 0
        );
        List<Integer> negativeNumbers = GenericMethods.processCollection(
                numbers,
                ArrayList::new,
                num -> num < 0
        );
        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> groupedByLength = new HashMap<>();
        
        GenericMethods.processCollection(
                strings,
                () -> new ArrayList<>(),
                str -> {
                    groupedByLength.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
                    return true;
                }
        );

        System.out.println("Строки, сгруппированные по длине: " + groupedByLength);

        List<String> uniqueStrings = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueSet = GenericMethods.processCollection(
                uniqueStrings,
                HashSet::new,
                value -> true
        );
        System.out.println("Уникальные строки: " + uniqueSet);

    }

    private void listTasks() {
        System.out.println("12. Без null");
        System.out.println("15. Обобщенная линия");
        System.out.println("2. Сдвинуть линию");
        System.out.println("31. Функция");
        System.out.println("32. Фильтр");
        System.out.println("33. Сокращение");
        System.out.println("34. Коллекционирование");
    }
}
