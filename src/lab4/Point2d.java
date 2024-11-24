package lab4;

public class Point2d implements IPoint{
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        var other = (Point2d) obj;
        return this.x == other.getX() && this.y == other.getY();
    }

    @Override
    public Point2d clone() {
        return new Point2d(x, y);
    }
}