package lab3;
import common.IRunnable;
import common.InputValidator;
import lab3.Points.OtherPoint2d;
import lab3.Points.OtherPoint3d;
import lab3.Points.Point1d;
import lab3.Points.Point2d;
import lab3.Points.Point3d;

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
                case 6: runTask5(); break;
                case 7: runTask5(); break;
                case 8: runTask5(); break;

                default: System.out.print("Задания с таким номером нет. ");
            }
        }
    }

    private void runTask5() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runTask5'");
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
    }

    private void runTask3() {
        System.out.println("Трехмерная точка.");
        System.out.println("Создадим трехмерную точку. Задайте координаты X, Y, Z:");
        var point3d = new Point3d(
            InputValidator.readInt(false),
            InputValidator.readInt(false),
            InputValidator.readInt(false));
        System.err.println("Полученная точка:" + point3d);
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
        ImmutableArray array4 = array1.withValueAt(
            InputValidator.readInt(true), 
            InputValidator.readInt(false));

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
        System.err.println("Созданные линии:");
        System.err.println(firstLine);
        System.err.println(secondLine);

        System.err.println("Изменим координату конца первой линии");
        end = firstLine.getEnd();
        end.setX(InputValidator.readInt(false));
        end.setY(InputValidator.readInt(false));

        System.err.println("Те же линии:");
        System.err.println(firstLine);
        System.err.println(secondLine);
        System.err.println("Теперь концы не совпадают, т.к. линии не ссылаются на один объект точки");
        
        System.err.println("\n12 Квадрат");
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
