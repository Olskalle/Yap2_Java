package ru.zolnikov.lab2;

import ru.zolnikov.common.*;
import ru.zolnikov.lab2.geometry.*;

public class Lab2 implements IRunnable{

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
                case 1: runTask1(); break;
                case 2: runTask2(); break;
                case 3: runTask3(); break;
                case 4: runTask4(); break;
                case 5: runTask5(); break;

                default: System.out.print("Задания с таким номером нет. ");
            }
        }
    }

    private void runTask4() {
        // 4.1
        System.out.println("Задание 4. Создаем точку / Создаем линию. Введите координаты для трех точек");
        var points = new Point[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите координаты. Сначала X, затем Y");

            points[i] = new Point(
                InputValidator.readInt(false),
                InputValidator.readInt(false));
        }

        System.out.print("Точки: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(points[i] + " ");
        }
        System.out.println("");

        // 4.2
        var firstLineStart = new Point(1, 3);
        var secondLineEnd = new Point(25, 10);

        var lines = new Line[] {
            new Line(firstLineStart, new Point(23, 8)),
            new Line(new Point(5, 10), secondLineEnd),
            new Line(firstLineStart, secondLineEnd),
        };

        System.out.println("Линии:");
        printArray(lines, "\n");

         // п.4 задания
        System.out.println("Измените начала координаты первой линии. Введите сначала X, затем Y");
            firstLineStart.setX(InputValidator.readInt(false));
            firstLineStart.setY(InputValidator.readInt(false));

        System.out.println("Измените конца координаты второй линии. Введите сначала X, затем Y");
            secondLineEnd.setX(InputValidator.readInt(false));
            secondLineEnd.setY(InputValidator.readInt(false));

        System.out.println("Измененные линии:");
        printArray(lines, "\n");

        // п.5 задания
        System.out.println("Измените конца координаты первой линии. Введите сначала X, затем Y");
        lines[0].setEnd(new Point(
            InputValidator.readInt(false),
            InputValidator.readInt(false)));

        System.out.println("Измените начала координаты первой линии. Введите сначала X, затем Y");
        lines[0].setStart(new Point(
            InputValidator.readInt(false),
            InputValidator.readInt(false)));
        
        System.out.println("Измененные линии:");
        printArray(lines, "\n"); 
    }

    private void runTask2() {
        var firstLineStart = new PointSimple();
        firstLineStart.setX(1);
        firstLineStart.setY(3);

        var firstLineEnd = new PointSimple();
        firstLineEnd.setX(23);
        firstLineEnd.setY(8);

        var secondLineStart = new PointSimple();
        secondLineStart.setX(5);
        secondLineStart.setY(10);

        var secondLineEnd = new PointSimple();
        secondLineEnd.setX(25);
        secondLineEnd.setY(10);

        var lines = new LineSimple[] {
            new LineSimple(),
            new LineSimple(),
            new LineSimple(),
        };
        
        lines[0].setStart(firstLineStart);
        lines[0].setEnd(firstLineEnd);

        lines[1].setStart(secondLineStart);
        lines[1].setEnd(secondLineEnd);

        lines[2].setStart(firstLineStart);
        lines[2].setEnd(secondLineEnd);

        System.out.println("Линии:");
        printArray(lines, "\n");

        // п.4 задания
        System.out.println("Измените начала координаты первой линии. Введите сначала X, затем Y");
        firstLineStart.setX(InputValidator.readInt(false));
        firstLineStart.setY(InputValidator.readInt(false));

        System.out.println("Измените конца координаты второй линии. Введите сначала X, затем Y");
        secondLineEnd.setX(InputValidator.readInt(false));
        secondLineEnd.setY(InputValidator.readInt(false));

        System.out.println("Измененные линии:");
        printArray(lines, "\n");

        // п.5 задания
        System.out.println("Измените конца координаты первой линии. Введите сначала X, затем Y");
        lines[0].getEnd().setX(InputValidator.readInt(false));
        lines[0].getEnd().setY(InputValidator.readInt(false));

        System.out.println("Измените начала координаты первой линии. Введите сначала X, затем Y");
        var newStart = new PointSimple();
        newStart.setX(InputValidator.readInt(false));
        newStart.setY(InputValidator.readInt(false));
        lines[0].setStart(newStart);

        System.out.println("Измененные линии:");
        printArray(lines, "\n");
    } 

    private void runTask3() {
        var vasya = new Student("Вася", new int[] {3, 4, 5});
        var petya = new Student("Петя", vasya.getGrades());

        System.out.println(vasya);
        System.out.println(petya);

        System.out.println("Изменим первую оценку Пети на 5");
        var petyaGrades = petya.getGrades(); 
        petyaGrades[0] = 5;
        
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println("Оценка Васи также изменилась, т.к. оценки Васи были переданы Пете в конструктор по ссылке");

        System.out.println("Создадим студента Андрея, скопируем оценки Пети и изменим одну оценку у Васи");
        var andrey = new Student("Андрей", petyaGrades.clone());
        petyaGrades[1] = 2;

        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(andrey);
        System.out.println("Оценки Андрея не изменились, т.к. в конструктор был передан клон массива оценок");
    }

    private void runTask1() {
        System.out.println("Задание 1. Введите координаты для трех точек");
        var points = new PointSimple[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите координаты. Сначала X, затем Y");

            points[i] = new PointSimple();
            points[i].setX(InputValidator.readInt(false));
            points[i].setY(InputValidator.readInt(false));
        }

        System.out.print("Точки: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(points[i] + " ");
        }
        System.out.println("");
    }

    private void runTask5() {
        System.out.println("Задание 5. Длина линии.");
        var line = new Line(1, 1, 10 , 15);

        System.out.println(line + ", ее длина: " + line.getLength());
    }

    private void listTasks() {
        System.out.println("Задание 1. Точка координат");
        System.out.println("Задание 2. Прямая");
        System.out.println("Задание 3. Студент");
        System.out.println("Задание 4. Создаем точку / Создаем линию");
        System.out.println("Задание 5. Длина линии");
    }

    private <T> void printArray(T[] array, String delimeter) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + delimeter);
        }
        System.out.println(array[array.length - 1]);
    }
}

