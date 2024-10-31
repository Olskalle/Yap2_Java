package lab3;

public class Square {
    private Point topLeftPoint;
    private int sideLength;
    
    public int getSideLength() {
        return sideLength;
    }

    public Point getTopLeftPoint() {
        return topLeftPoint;
    }

    public Square(Point topLeft, int length) throws IllegalArgumentException {
        if (length < 0)
            throw new IllegalArgumentException("Длина была меньше нуля");
        
        topLeftPoint = topLeft;
        sideLength = length;
    }

    public Square(int topLeftX,int topLeftY, int length) throws IllegalArgumentException {
        if (length < 0)
            throw new IllegalArgumentException("Длина была меньше нуля");
        
        topLeftPoint = new Point(topLeftX, topLeftY);
        sideLength = length;
    }

    public Polyline getPolyline() {
        return new Polyline(
            topLeftPoint,
            new Point(topLeftPoint.x + sideLength, topLeftPoint.y),
            new Point(topLeftPoint.x + sideLength, topLeftPoint.y - sideLength),
            new Point(topLeftPoint.x, topLeftPoint.y - sideLength),
            topLeftPoint);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeftPoint + "со стороной " + sideLength;
    }
}
