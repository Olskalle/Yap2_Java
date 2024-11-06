import lab1.Lab1;
import lab2.Lab2;
import lab3.Lab3;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            String xStr = args[0];
            String yStr = args[1];
            
            double result = pow(xStr, yStr);
            
            if (result != -1) {
                System.out.println("Результат: " + result);
            }
            else {
                System.out.println("Возникла ошибка при вычислении");
            }
        }
        else {
            System.out.println("Передано недостаточно параметров для вычисления степени");
        }
        
        var lab = new Lab3();

        lab.run();
    }

    public static double pow(String xStr, String yStr) {
        int x, y;

        try {
            x = Integer.parseInt(xStr); 
            y = Integer.parseInt(yStr);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректные целые числа.");
            return -1;
        }
        
        return Math.pow(x, y);
    }
}

