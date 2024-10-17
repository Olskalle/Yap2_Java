package lab2;
import common.IRunnable;
import common.InputValidator;

public class Lab2 implements IRunnable{

    public void run() {
        loopTasks();
    }

    private void loopTasks() {
        var exitRequested = false;

        listTasks();
        while (!exitRequested) {
            println("\nВведите номер задания (введите 0 для выхода):");
            var taskNum = InputValidator.readInt(true);

            switch (taskNum) {
                case 0:
                    exitRequested = true;
                    println("Выход...");
                    break;
                case 1: runTask1(); break;
                case 2: runTask2(); break;
                case 3: runTask3(); break;
                case 4: runTask4(); break;
                case 5: runTask5(); break;

                default: print("Задания с таким номером нет. ");
            }
        }
    }

    private void runTask4() {
        // 4.1
        println("Задание 4. Создаем точку / Создаем линию. Введите координаты для трех точек");
        var points = new Point[3];
        for (int i = 0; i < 3; i++) {
            println("Введите координаты. Сначала X, затем Y");

            points[i] = new Point(
                InputValidator.readInt(false),
                InputValidator.readInt(false));
        }

        print("Точки: ");
        for (int i = 0; i < 3; i++) {
            print(points[i].toString() + " ");
        }
        println("");

        // 4.2
        var firstLineStart = new Point(1, 3);
        var secondLineEnd = new Point(25, 10);

        var lines = new Line[] {
            new Line(firstLineStart, new Point(23, 8)),
            new Line(new Point(5, 10), secondLineEnd),
            new Line(firstLineStart, secondLineEnd),
        };

        println("Линии:");
        printArray(lines, "\n");

         // п.4 задания
        println("Измените начала координаты первой линии. Введите сначала X, затем Y");
            firstLineStart.setX(InputValidator.readInt(false));
            firstLineStart.setY(InputValidator.readInt(false));

        println("Измените конца координаты второй линии. Введите сначала X, затем Y");
            secondLineEnd.setX(InputValidator.readInt(false));
            secondLineEnd.setY(InputValidator.readInt(false));

        println("Измененные линии:");
        printArray(lines, "\n");

        // п.5 задания
        println("Измените конца координаты первой линии. Введите сначала X, затем Y");
        lines[0].setEnd(new Point(
            InputValidator.readInt(false),
            InputValidator.readInt(false)));

        println("Измените начала координаты первой линии. Введите сначала X, затем Y");
        lines[0].setStart(new Point(
            InputValidator.readInt(false),
            InputValidator.readInt(false)));
        
        println("Измененные линии:");
        printArray(lines, "\n"); 
    }

    private void runTask2() {
        var firstLineStart = new PointSimple();
        firstLineStart.X = 1;
        firstLineStart.Y = 3;

        var firstLineEnd = new PointSimple();
        firstLineEnd.X = 23;
        firstLineEnd.Y = 8;

        var secondLineStart = new PointSimple();
        secondLineStart.X = 5;
        secondLineStart.Y = 10;

        var secondLineEnd = new PointSimple();
        secondLineEnd.X = 25;
        secondLineEnd.Y = 10;

        var lines = new LineSimple[] {
            new LineSimple(),
            new LineSimple(),
            new LineSimple(),
        };
        
        lines[0].Start = firstLineStart;
        lines[0].End = firstLineEnd;

        lines[1].Start = secondLineStart;
        lines[1].End = secondLineEnd;

        lines[2].Start = firstLineStart;
        lines[2].End = secondLineEnd;

        println("Линии:");
        printArray(lines, "\n");

        // п.4 задания
        println("Измените начала координаты первой линии. Введите сначала X, затем Y");
        firstLineStart.X = InputValidator.readInt(false);
        firstLineStart.Y = InputValidator.readInt(false);

        println("Измените конца координаты второй линии. Введите сначала X, затем Y");
        secondLineEnd.X = InputValidator.readInt(false);
        secondLineEnd.Y = InputValidator.readInt(false);

        println("Измененные линии:");
        printArray(lines, "\n");

        // п.5 задания
        println("Измените конца координаты первой линии. Введите сначала X, затем Y");
        lines[0].End.X = InputValidator.readInt(false);
        lines[0].End.Y = InputValidator.readInt(false);

        println("Измените начала координаты первой линии. Введите сначала X, затем Y");
        var newStart = new PointSimple();
        newStart.X = InputValidator.readInt(false);
        newStart.Y = InputValidator.readInt(false);
        lines[0].Start = newStart;

        println("Измененные линии:");
        printArray(lines, "\n");
    } 

    private void runTask3() {
        var vasya = new Student("Вася", new int[] {3, 4, 5});
        var petya = new Student("Петя", vasya.getGrades());

        println(vasya.toString());
        println(petya.toString());

        println("Изменим первую оценку Пети на 5");
        var petyaGrades = petya.getGrades(); 
        petyaGrades[0] = 5;
        
        println(vasya.toString());
        println(petya.toString());
        println("Оценка Васи также изменилась, т.к. оценки Васи были переданы Пете в конструктор по ссылке");

        println("Создадим студента Андрея, скопируем оценки Пети и изменим одну оценку у Васи");
        var andrey = new Student("Андрей", petyaGrades.clone());
        petyaGrades[1] = 2;

        println(vasya.toString());
        println(petya.toString());
        println(andrey.toString());
        println("Оценки Андрея не изменились, т.к. в конструктор был передан клон массива оценок");
    }

    private void runTask1() {
        println("Задание 1. Введите координаты для трех точек");
        var points = new PointSimple[3];
        for (int i = 0; i < 3; i++) {
            println("Введите координаты. Сначала X, затем Y");

            points[i] = new PointSimple();
            points[i].X = InputValidator.readInt(false);
            points[i].Y = InputValidator.readInt(false);
        }

        print("Точки: ");
        for (int i = 0; i < 3; i++) {
            print(points[i].toString() + " ");
        }
        println("");
    }

    private void runTask5() {
        println("Задание 5. Длина линии.");
        var line = new Line(1, 1, 10 , 15);

        println(line.toString() + ", ее длина: " + line.getLength());
    }

    private static void println(String output) {
        System.out.println(output);
    }

    private static void print(String string) {
        System.out.print(string);
    }

    private void listTasks() {
        // Print all task names
    }

    private <T> void printArray(T[] array, String delimeter) {
        for (int i = 0; i < array.length - 1; i++) {
            print(array[i].toString() + delimeter);
        }
        println(array[array.length - 1].toString());
    }
}

