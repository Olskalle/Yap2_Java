package ru.zolnikov.lab3.geometry.points;

public class ColoredOtherPoint2d 
    extends OtherPoint2d 
    implements IColored {
    
    protected String color;
    
    public ColoredOtherPoint2d(int x) {
        super(x);
    }

    public ColoredOtherPoint2d(int x, int y) {
        super(x, y);
    }
        
    public ColoredOtherPoint2d(int x, String color) {
        super(x);
        this.color = color;
    }

    public ColoredOtherPoint2d(int x, int y, String color) {
        super(x, y);
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