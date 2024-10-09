import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        loopTasks();
    }

    private static void loopTasks() {
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
                case 11:
                    println("[Задание 1.1] Дробная часть");
                    println("Дробная часть числа: " + Tasks.fraction(InputValidator.readDouble()));
                    break;
                case 13:
                    println("[Задание 1.3] Букву в число");
                    println("Символ, преобразованный в число: " + Tasks.charToNum(InputValidator.readDigit()));
                    break;
                case 15:
                    println("[Задание 1.5] Двузначное");
                    println("Является ли число двузначным?: " + Tasks.is2Digit(InputValidator.readInt(false)));
                    break;
                case 17:
                    println("[Задание 1.7] Диапазон");
                    println("Введите границы диапазона.");
                    var a = InputValidator.readInt(false);
                    var b = InputValidator.readInt(false);
                    
                    println("Введите число для проверки.");
                    var x = InputValidator.readInt(false);
                    println(String.format("Находится ли число %s между %s и %s?: ", x, a, b) + Tasks.isInRange(a, b, x));
                    break;
                case 19:
                    println("[Задание 1.9] Равенство");
                    println("Введите три числа.");
                
                    println("Равны ли все три введенных числа?: " + Tasks.isEqual(
                        InputValidator.readInt(false),
                        InputValidator.readInt(false),
                        InputValidator.readInt(false)));
                    break;
                case 21:
                    println("[Задание 2.1] Модуль числа");
                    println("Модуль введенного числа: " + Tasks.abs(InputValidator.readInt(false)));
                    break;
                case 23:
                    println("[Задание 2.3] Тридцать пять");
                    println("Число кратно 3 или 5, но не кратно обоим?: " + Tasks.is35(InputValidator.readInt(true)));
                    break;
                case 25:
                    println("[Задание 2.5] Тройной максимум");
                    println("Максимальное из трех введенных: " + Tasks.max3(
                        InputValidator.readInt(false),
                        InputValidator.readInt(false),
                        InputValidator.readInt(false)));
                        break;
                case 27:
                    println("[Задание 2.7] Двойная сумма");
                    println("Сумма (в диапазоне от 10 до 19 == 20): " + Tasks.sum2(
                        InputValidator.readInt(false),
                        InputValidator.readInt(false)));
                    break;
                case 29:
                    println("[Задание 2.9] День недели");
                    println("День недели: " + Tasks.day(InputValidator.readInt(true)));
                    break;
                case 31:
                    println("[Задание 3.1] Числа подряд");
                    println("Значения от 0 до введенного числа: " + Tasks.listNums(InputValidator.readInt(false)));
                    break;
                case 33:
                    println("[Задание 3.3] Четные числа");
                    println("Четные числа от 0 до введенного числа : " + Tasks.chet(InputValidator.readInt(false)));
                    break;
                case 35:
                    println("[Задание 3.5] Длина числа");
                    println("Длина числа: " + Tasks.numLen(InputValidator.readLong(false)));
                    break;
                case 37:
                    println("[Задание 3.7] Квадрат");
                    println("Введите сторону квадрата.");
                    Tasks.square(InputValidator.readInt(true));
                    break;
                case 39:
                    println("[Задание 3.9] Правый треугольник");
                    println("Правый треугольник. Введите высоту треугольника.");
                    Tasks.rightTriangle(InputValidator.readInt(true));
                    break;
                case 41:
                    println("[Задание 4.1] Поиск первого значения");
                    println("Индекс первого вхождение указанного числа в массив: " + Tasks.findFirst(
                        InputValidator.readIntArray(),
                        InputValidator.readInt(false)));
                    break;
                case 43:
                    println("[Задание 4.3] Поиск максимального"); 
                    println("Максимальное значение по модулю в массиве: " + Tasks.maxAbs(InputValidator.readIntArray()));
                    break;
                case 45:
                    println("[Задание 4.5] Добавление массива в массив");
                    println("Введите два массива. Один массив будет вставлен в другой в определенный индекс");
                    println("Результат добавления одного массива в другой: " + Arrays.toString(Tasks.add(
                        InputValidator.readIntArray(),
                        InputValidator.readIntArray(),
                        InputValidator.readInt(true))));
                    break;
                case 47:
                    println("[Задание 4.7] Возвратный реверс");
                    println("Перевернутый массив: " + Arrays.toString(
                        Tasks.reverseBack(InputValidator.readIntArray())));
                    break;
                case 49:
                    println("[Задание 4.9] Все вхождения");
                    println("Все вхождения введенного числа в массив: " + Arrays.toString(Tasks.findAll(
                        InputValidator.readIntArray(),
                        InputValidator.readInt(false))));
                    break;
                default:
                    System.out.println("Задания с таким номером нет");
                    break;
            }
        }
    }

    private static void println(String output) {
        System.out.println(output);
    }

    private static void listTasks() {
        println("11. Дробная часть");
        println("13. Букву в число");
        println("15. Двузначное");
        println("17. Диапазон");
        println("19. Равенство");
        println("21. Модуль числа");
        println("23. Тридцать пять");
        println("25. Тройной максимум");
        println("27. Двойная сумма");
        println("29. День недели");
        println("31. Числа подряд");
        println("33. Четные числа");
        println("35. Длина числа");
        println("37. Квадрат");
        println("39. Правый треугольник");
        println("41. Поиск первого значения");
        println("43. Поиск максимального");
        println("45. Добавление массива в массив");
        println("47. Возвратный реверс");
        println("49. Все вхождения");
    }
}

