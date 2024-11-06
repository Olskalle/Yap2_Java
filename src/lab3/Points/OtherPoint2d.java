package lab3.Points;

public class OtherPoint2d extends Point1d {

    public OtherPoint2d(int x) {
        super(x);
        y = 0;
    }

    public OtherPoint2d(int x, int y) {
        super(x);
        this.y = y;
    }

    protected int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка в координате {" + x + ", " + y + "}";
    }
}