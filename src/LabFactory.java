import common.IRunnable;
import lab1.Lab1;
import lab2.Lab2;
import lab3.Lab3;
import lab4.Lab4;
import lab5.Lab5;
import lab6.Lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LabFactory {

    private static final Map<Integer, Supplier<IRunnable>> labMap = new HashMap<>();

    static {
        labMap.put(1, Lab1::new);
        labMap.put(2, Lab2::new);
        labMap.put(3, Lab3::new);
        labMap.put(4, Lab4::new);
        labMap.put(5, Lab5::new);
        labMap.put(6, Lab6::new);
    }

    public static IRunnable getLab(int choice) {
        Supplier<IRunnable> labSupplier = labMap.get(choice);
        return (labSupplier != null) ? labSupplier.get() : null;
    }
}

