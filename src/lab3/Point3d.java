package lab3;

public class Point3d extends Point{
    private int z;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + ";" + z +"}";
    }

}

class Point {
    protected int x;
    protected int y;

    public Point(int x, int y) {
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