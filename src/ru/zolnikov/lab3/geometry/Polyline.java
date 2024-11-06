package ru.zolnikov.lab3.geometry;

import java.util.Arrays;
import ru.zolnikov.lab3.geometry.points.Point2d;

public class Polyline {
    private Point2d[] points;
    
    public Polyline() {
        points = new Point2d[0];
    }

    public Polyline(Point2d... points) {
        this.points = points.clone();
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

    public void movePointAtIndex(int index, int x, int y) {
        if (index >= points.length || index < 0)
            return;

        var point = points[index];
        point.setX(x);
        point.setY(y); 
    }

    public int count() {
        return points.length;
    }

    @Override
    public String toString() {
        return "Линия " + Arrays.toString(points);
    }
}
