package ru.zolnikov.lab3.geometry.points;

public class Point1d extends PointBase{
    protected int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Point1d(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Точка в координате {" + x + "}";
    }
}