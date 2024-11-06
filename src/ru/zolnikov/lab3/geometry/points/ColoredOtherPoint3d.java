package ru.zolnikov.lab3.geometry.points;

public class ColoredOtherPoint3d 
    extends OtherPoint3d 
    implements IColored {

    protected String color;
    
    public ColoredOtherPoint3d(int x, String color) {
        super(x);
        this.color = color;
    }

    public ColoredOtherPoint3d(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColoredOtherPoint3d(int x, int y, int z, String color) {
        super(x, y, z);
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
        
    @Override
    public String toString() {
        return super.toString() + " цвета " + color;
    }
}