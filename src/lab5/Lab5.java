package lab5;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.IRunnable;
import common.InputValidator;
import lab3.Points.Point2d;

public class Lab5 implements IRunnable {

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
                case 1:
                    runTask1();
                    break;
                case 2:
                    runTask2();
                    break;
                case 3:
                    runTask3();
                    break;
                case 4:
                    runTask4();
                    break;
                case 5:
                    runTask5();
                    break;
                case 6:
                    runTask6();
                    break;
                case 71:
                    runTask71();
                    break;
                case 72:
                    runTask72();
                    break;

                default:
                    System.out.print("Задания с таким номером нет. ");
            }
        }
    }

    private void runTask1() {
        System.out.println("Дробь");
    
        IFraction fraction1 = new Fraction(3, 4);
        System.out.println("fraction1: " + fraction1);
        System.out.println("Вещественное значение: " + fraction1.getDoubleValue());
    
        IFraction cachedFraction = new CachedFractionDecorator(fraction1);
    
        System.out.println("cachedFraction: " + cachedFraction);
        System.out.println("Вещественное значение (из кеша): " + cachedFraction.getDoubleValue());
        System.out.println("Вещественное значение (еще раз, из кеша): " + cachedFraction.getDoubleValue());
    
        cachedFraction.setNumerator(5);
        System.out.println("cachedFraction после изменения числителя: " + cachedFraction);
        System.out.println("Вещественное значение (новое вычисление): " + cachedFraction.getDoubleValue());
        
        IFraction fraction2 = new Fraction(5, 4);
        System.out.println("fraction2: " + fraction2); 
        System.out.println("Дроби равны? " + fraction2.equals(cachedFraction));
    }

    private void runTask2() {
        System.out.println("Количество мяуканий");
        System.out.println("Введите имя кота");
        var funs = new Funs();
        Meowable cat = new Cat(InputValidator.readString());

        funs.meowCare(cat);
        funs.meow();
        funs.meow();
        funs.meow();
        funs.meow();
        funs.meow();
        System.out.println(funs);
       }

    private void runTask3() {
        System.out.println("Удаление всех вхождений из списка");
        List<Integer> numbers = InputValidator.readIntegerArray();

        System.out.println("Список до удаления: " + numbers);

        System.out.println("Введите число, которое хотите удалить из массива");
        var x = InputValidator.readInt(true);
        
        ListExtensions.removeAllEntries(numbers, x);
        System.out.println("Список после удаления: " + numbers);
    }

    private void runTask4() {
        File file = new File("src/lab5/input/task4.txt");
        System.out.println("Логины:");
        LoginGenerator.generate(file.getAbsolutePath());
    }

    private void runTask5() {
        File file = new File("src/lab5/input/task5.txt");
        System.out.println("Все звонкие согласные в алфавитном порядке, встречающиеся в тексте:");
        ConsonantsExtractor.extract(file.getAbsolutePath());
    }

    private void runTask6() {
        System.out.println("Очередь:");
        Queue<Integer> queue = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        for(var s : queue) { 
            System.out.println(s.toString()); 
        }

        System.out.println("Развернутая очередь:");
        queue = QueueExtensions.reverse(queue);
        for(var s : queue) { 
            System.out.println(s.toString()); 
          }
    }

    private void runTask71() {
        System.out.println("Стрим. Полилиния");
        ArrayList<Point2d> lines = new ArrayList<Point2d>(List.of(
            new Point2d(1, 2),
            new Point2d(1, 2),
            new Point2d(100, -4),
            new Point2d(1, -2),
            new Point2d(5, 80),
            new Point2d(0, 2)
        ));

        System.out.println("Точки:" + lines);

        var polyline = PolylineCreator.createPolyline(lines);
        System.out.println(polyline);
    }

    private void runTask72() {
        System.out.println("Группировка имен по номерам");
        PersonGrouping.group("src/lab5/input/task72.txt");
    }

    private void listTasks() {
        System.out.println("1. Шаблоны. Дробь");
        System.out.println("2. Мяуканье");
        System.out.println("3. Список");
        System.out.println("4. Мап");
        System.out.println("5. Сет");
        System.out.println("6. Очередь");
        System.out.println("71. Стрим 1");
        System.out.println("72. Стрим 2");
    }
}
