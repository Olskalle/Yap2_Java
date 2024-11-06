package ru.zolnikov.lab3.geometry.points;

public class OtherPoint3d extends OtherPoint2d {

    public OtherPoint3d(int x) {
        super(x);
        z = 0;
    }

    public OtherPoint3d(int x, int y) {
        super(x, y);
        z = 0;
    }

    public OtherPoint3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    protected int z;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Точка в координате {" + x + ", " + y + ", " + z + "}";
    }
}