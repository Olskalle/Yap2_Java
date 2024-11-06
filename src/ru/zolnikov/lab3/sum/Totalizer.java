package ru.zolnikov.lab3.sum;

import ru.zolnikov.main.ISummable;

public class Totalizer implements ISummable{
    @Override
    public double sum(double... values) {
        if (values.length == 0)
            return .0;

        var total = .0;
        for (var value : values) {
           total += value; 
        }

        return total;
    }
}