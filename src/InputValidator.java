import java.util.Scanner;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(boolean shouldBePositive) {
        int value;
        while (true) {
            if (shouldBePositive) {
                System.out.print("Введите положительное целое число: ");
            }
            else {
                System.out.print("Введите целое число: ");
            }

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();

                if (shouldBePositive && value < 0) {
                    System.out.println("Ошибка: число должно быть больше нуля.");
                } 
                else {
                    break;
                }
            } 
            else {
                System.out.println("Ошибка: введено не целое число.");
                scanner.next();
            }
        }
        return value;
    }

    public static long readLong(boolean shouldBePositive) {
        long value;
        while (true) {
            if (shouldBePositive) {
                System.out.print("Введите положительное целое число типа long: ");
            }
            else {
                System.out.print("Введите целое число типа long: ");
            }

            if (scanner.hasNextLong()) {
                value = scanner.nextLong();

                if (shouldBePositive && value < 0) {
                    System.out.println("Ошибка: число должно быть больше нуля.");
                } 
                else {
                    break;
                }
            } 
            else {
                System.out.println("Ошибка: введено не целое число типа long.");
                scanner.next();
            }
        }
        return value;
    }

    public static double readDouble() {
        double value;
        while (true) {
            System.out.print("Введите дробное число с запятой в качестве разделителя: ");
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                System.out.println("Ошибка: введено не дробное число");
                scanner.next();
            }
        }
        return value;
    }

    public static String readString() {
        System.out.print("Введите строку: ");
        return scanner.next();
    }

    public static char readChar() {
        System.out.print("Введите символ");
        return scanner.next(".").charAt(0);
    }

    public static char readDigit() {
        while (true) {
            System.out.print("Введите число от 0 до 9: ");
            var digit = scanner.next(".").charAt(0);
        
            if (digit >= '0' && digit <= '9') {
                return digit;
            }

            System.out.println("Введено не число");
        }
    }

    public static int[] readIntArray() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (true) {
            System.out.print("Введите массив целых чисел через пробел: ");
            var arrTemp = scanner.nextLine().split(" ");
        
            var ints = new int[arrTemp.length];
            try {
                for (int i = 0; i < ints.length; i++) {
                    ints[i] = Integer.parseInt(arrTemp[i]);
                }

                return ints;
            } catch (NumberFormatException e) {
                ints = null;
                System.out.println("Один или более элементов не являлись целым числом");
            }
        }
    }
}