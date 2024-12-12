import common.IRunnable;
import common.InputValidator;
import lab1.Lab1;
import lab2.Lab2;
import lab3.Lab3;
import lab4.Lab4;
import lab5.Lab5;
import lab6.Lab6;

public class App {
    public static void main(String[] args) throws Exception {
         while (true) { 
            System.out.println("Выберите лабораторную работу:");
            System.out.println("1. Lab 1");
            System.out.println("2. Lab 2");
            System.out.println("3. Lab 3");
            System.out.println("4. Lab 4");
            System.out.println("5. Lab 5");
            System.out.println("6. Lab 6");
            System.out.println("0. Exit");

            int choice = InputValidator.readInt(true);

            if (choice == 0) {
                System.out.println("Выход...");
                break;
            }

            IRunnable lab = LabFactory.getLab(choice);

            if (lab == null) {
                System.out.println("Работы с таким номером нет. Введите заново.");
                continue;
            }

            lab.run();
        }
    }
}

