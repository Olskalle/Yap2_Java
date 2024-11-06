package lab3;

import java.util.Arrays;

import lab3.Points.Point2d;

public class Polyline {
    private Point2d[] points;
    
    public Polyline() {
        points = new Point2d[0];
    }

    public Polyline(Point2d... points) {
        points = points.clone();
    }

    public void addPoints(Point2d... points) {
        var result = Arrays.copyOf(this.points, this.points.length + points.length);
        System.arraycopy(points, 0, result, this.points.length, points.length);

        points = result;
    }

    public double totalLength() {
        if (points.length == 0)
            return 0;

        var current = points[0];
        var total = 0.0;
        for (var i = 1; i < points.length; i++) {
            int deltaX = points[i].getX() - current.getX();
            int deltaY = points[i].getY() - current.getY();
        
            total += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            current = points[i];
        }

        return total;
    } 

    @Override
    public String toString() {
        return "Линия " + Arrays.toString(points);
    }
}
