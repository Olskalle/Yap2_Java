package lab3.Points;

public class Point2d {
    protected int x;
    protected int y;

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int value) {
        x = value;  
    }

    public void setY(int value) {
        y = value;
    }

    public int getX() {
        return x;  
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}