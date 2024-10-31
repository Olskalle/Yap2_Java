package lab3;
import common.IRunnable;
import common.InputValidator;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runTask4'");
    }

    private void runTask3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runTask3'");
    }

    private void runTask2() {
        System.out.println("Создадим неизменяемый массив через массив:");
        ImmutableValueList list1 = new ImmutableValueList(InputValidator.readIntArray());
        System.out.println("Неизменияемый массив 1: " + list1);
        
        System.out.println("Создадим неизменяемый массив через перечисление чисел:");
        ImmutableValueList list2 = new ImmutableValueList(
            InputValidator.readInt(false),
            InputValidator.readInt(false),
            InputValidator.readInt(false)
            );
        System.out.println("Неизменяемый массив 2: " + list2);
        
        System.out.println("Создадим неизменяемый массив через другой неизменяемый массив:");
        ImmutableValueList list3 = new ImmutableValueList(list1);
        System.out.println("Неимзеняемый массив 3: " + list3);

        System.out.println("Выберем элемент из массива по индексу: ");
        var index = 
        System.out.println("Get value at index 1 from List1: " + list1.get(1));
        System.out.println("Size of List1: " + list1.size()); // 3
        System.out.println("Is List1 empty? " + list1.isEmpty()); // false

        // Показать, как создать новый список с изменением значения
        ImmutableValueList list4 = list1.withValueAt(1, 99);
        System.out.println("List4 (new value at index 1): " + list4); // [1, 99, 3]
        System.out.println("List1 remains unchanged: " + list1); // [1, 2, 3]
    }

    private void runTask1() {
        System.out.println("6. Отдельные линии");
        System.out.println("Создадим две линии, у которых концы будут находиться в одной точке. Введите координаты начал этих двух точек и координату конца");
        var firstLineStart = new Point(
            InputValidator.readInt(false),
            InputValidator.readInt(false));

        var secondLineStart = new Point(
            InputValidator.readInt(false),
            InputValidator.readInt(false));
        
        var end = new Point(
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
