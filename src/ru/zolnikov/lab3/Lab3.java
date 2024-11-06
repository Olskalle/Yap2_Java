package ru.zolnikov.lab3;

import ru.zolnikov.common.*;
import ru.zolnikov.lab3.collections.ImmutableArray;
import ru.zolnikov.lab3.geometry.*;
import ru.zolnikov.lab3.geometry.points.*;
import ru.zolnikov.lab3.sum.Totalizer;

public class Lab3 implements IRunnable {

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
                case 6: runTask6(); break;
                case 7: runTask7(); break;
                case 8: runTask8(); break;

                default: System.out.print("Задания с таким номером нет. ");
            }
        }
    }

    private void runTask8() {
        System.out.println("Клонирование линий");
        System.out.println("Создадим линию:");

        System.out.println("Начальная точка. Введите X, Y:");
        var lineStart = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));
            
        System.out.println("Конечная точка. Введите X, Y:");
        var lineEnd = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));

        var line = new Line(lineStart, lineEnd);
        var lineClone = line.clone();

        System.out.println("Клонируем линию");
        System.out.println("Оригинальная линия: " + line);
        System.out.println("Клон линии: " + lineClone);
        System.out.println("Сравним линии через equals:" + line.equals(lineClone));
        System.out.println("Сравним линии по ссылке:" + (line == lineClone));
    }

    private void runTask7() {
        System.out.println("Навести порядок / Главный метод / Возведение в степень");
        System.out.println("204: No content");
    }
    
    private void runTask6() {
        System.out.println("Сравнение линий");
        System.out.println("Создадим две линии с одинаковыми координатами:");

        var lineStart = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));
        
        var lineEnd = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));

        var line1 = new Line(lineStart, lineEnd);
        var line2 = new Line(lineStart, lineEnd);

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Сравним линии через equals:" + line1.equals(line2));
        System.out.println("Сравним линии по ссылке:" + (line1 == line2));
    }

    private void runTask5() {
        System.out.println("Сложение");
        var totalizer = new Totalizer();

        System.out.println("Посчитаем с помощью класса Totalizer значение выражений");
        System.out.println("2 + 3/5 + 2.3");
        System.out.println(totalizer.sum(2, 3/5, 2.3 ));
        
        System.out.println("3.6 + 49/12 + 3 + 3/2");
        System.out.println(totalizer.sum(3.6, 49/12, 3, 3/2 ));
        
        System.out.println("1/3 + 1");
        System.out.println(totalizer.sum(1/3, 1));
    }

    private void runTask4() {
        System.out.println("Иерархия классов точек:");
        System.out.println("Точка с одной координатой:");
        System.out.println(new Point1d(InputValidator.readInt(false)));
        
        System.out.println("Точка с двумя координатами:");
        System.out.println(new OtherPoint2d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false)));
        
        System.out.println("Точка с тремя координатами:");
        System.out.println(new OtherPoint3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false)));

        System.out.println("Точка с тремя координатами и цветом:");
        System.out.println(new ColoredOtherPoint3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false),
            InputValidator.readString()));
    
        System.out.println("Точка с тремя координатами и цветом и временем появления:");
        System.out.println(new AppearingColoredOtherPoint3d(
            InputValidator.readInt(false), 
            InputValidator.readInt(false), 
            InputValidator.readInt(false),
            InputValidator.readString(),
            InputValidator.readTime()));
    }

    private void runTask3() {
        System.out.println("Трехмерная точка.");
        System.out.println("Создадим трехмерную точку. Задайте координаты X, Y, Z:");
        var point3d = new Point3d(
            InputValidator.readInt(false),
            InputValidator.readInt(false),
            InputValidator.readInt(false));
        System.out.println("Полученная точка:" + point3d);
    }

    private void runTask2() {
        System.out.println("Создадим неизменяемый массив через массив:");
        ImmutableArray array1 = new ImmutableArray(InputValidator.readIntArray());
        System.out.println("Неизменияемый массив 1: " + array1);
        
        System.out.println("Создадим неизменяемый массив через перечисление чисел:");
        ImmutableArray array2 = new ImmutableArray(
            InputValidator.readInt(false),
            InputValidator.readInt(false),
            InputValidator.readInt(false)
            );
        System.out.println("Неизменяемый массив 2: " + array2);
        
        System.out.println("Создадим неизменяемый массив через другой неизменяемый массив:");
        ImmutableArray array3 = new ImmutableArray(array1);
        System.out.println("Неимзеняемый массив 3: " + array3);

        System.out.println("Выберем элемент из массива по индексу: ");
        var index = InputValidator.readInt(true);

        try {
            System.out.println("Элемент массива_1 под номером " + index +": " + array1.get(index));
        } catch (Exception e) {
            System.out.println("Получили ошибку, что индекс находился за границами массива.");
            System.out.println(e.getMessage());
        }

        System.out.println("Размер массива 1: " + array1.size());
        System.out.println("Проверка массива 1 на пустоту: " + array1.isEmpty());
        
        System.out.println("Создадим копию массива 1 с измененным элементом. Введите индекс, который хотите заменить, затем новое значение:");
        ImmutableArray array4 = null;
        var isValid = false;

        while (!isValid) {
            try {
                array4 = array1.withValueAt(
                    InputValidator.readInt(true), 
                    InputValidator.readInt(false)); 

            } catch (Exception e) {
                System.out.println("Попали на исключение: " + e.getMessage());
                continue;
            }

            isValid = true;
        }

        System.out.println("Скопированный массив: " + array4);
        System.out.println("Исходный массив: " + array1);
    }

    private void runTask1() {
        System.out.println("6. Отдельные линии");
        System.out.println("Создадим две линии, у которых концы будут находиться в одной точке. Введите координаты начал этих двух точек и координату конца");
        var firstLineStart = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));

        var secondLineStart = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));
        
        var end = new Point2d(
            InputValidator.readInt(false),
            InputValidator.readInt(false));

        var firstLine = new Line(firstLineStart, end);
        var secondLine = new Line(secondLineStart, end);
        System.out.println("Созданные линии:");
        System.out.println(firstLine);
        System.out.println(secondLine);

        System.out.println("Изменим координату конца первой линии");
        end = firstLine.getEnd();
        end.setX(InputValidator.readInt(false));
        end.setY(InputValidator.readInt(false));

        System.out.println("Те же линии:");
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println("Теперь концы не совпадают, т.к. линии не ссылаются на один объект точки");
        
        System.out.println("\n12 Квадрат");
        System.out.println("Создадим квадрат в точке {5;3} со стороной 23");
        var square = new Square(5, 3, 23);
        System.out.println(square);
        
        var polyLine = square.getPolyline();
        System.out.println("Ломанная из квадрата: " + polyLine);
        System.out.println("Длина ломанной: " + polyLine.totalLength());
        
        polyLine.movePointAtIndex( polyLine.count() - 1, 15, 25);
        System.out.println("Сдвинем последнюю точку ломанной в позицию {15, 25}: " + polyLine);
        System.out.println("Длина ломанной: " + polyLine.totalLength());
    }

    private void listTasks() {
        System.out.println("1. Отдельные линии; Квадрат");
        System.out.println("2. Неизменяемый массив");
        System.out.println("3. Трехмерная точка");
        System.out.println("4. Точки");
        System.out.println("5. Сложение");
        System.out.println("6. Сравнение линий");
        System.out.println("7. Навести порядок, главный метод, Возвездение в степень");
        System.out.println("8. Клонирование линии");
    }
}
