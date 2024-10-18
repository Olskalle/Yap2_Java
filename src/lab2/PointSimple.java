package lab2;

class PointSimple {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    } 

    public int getY() {
        return y;
    }

    public PointSimple() {
        x = 0;
        y = 0;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}