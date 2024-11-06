package lab3;

import lab3.Points.Point2d;

public class Square {
    private Point2d topLeftPoint;
    private int sideLength;
    
    public int getSideLength() {
        return sideLength;
    }

    public Point2d getTopLeftPoint() {
        return topLeftPoint;
    }

    public Square(Point2d topLeft, int length) throws IllegalArgumentException {
        if (length < 0)
            throw new IllegalArgumentException("Длина была меньше нуля");
        
        topLeftPoint = topLeft;
        sideLength = length;
    }

    public Square(int topLeftX,int topLeftY, int length) throws IllegalArgumentException {
        if (length < 0)
            throw new IllegalArgumentException("Длина была меньше нуля");
        
        topLeftPoint = new Point2d(topLeftX, topLeftY);
        sideLength = length;
    }

    public Polyline getPolyline() {
        return new Polyline(
            topLeftPoint,
            new Point2d(topLeftPoint.getX() + sideLength, topLeftPoint.getY()),
            new Point2d(topLeftPoint.getX() + sideLength, topLeftPoint.getY() - sideLength),
            new Point2d(topLeftPoint.getX(), topLeftPoint.getY() - sideLength),
            topLeftPoint);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeftPoint + " со стороной " + sideLength;
    }
}
