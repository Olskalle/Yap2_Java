    package lab4;

public class Point3d extends Point2d{
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

    @Override
    public Point3d clone() {
        return new Point3d(x, y, z);
    }
}