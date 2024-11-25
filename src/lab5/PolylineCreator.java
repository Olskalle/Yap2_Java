package lab5;

import java.util.*;

import lab3.Polyline;
import lab3.Points.Point2d;

public class PolylineCreator {
    public static Polyline createPolyline(List<Point2d> points) {
        return new Polyline(points.stream()
            .distinct()
            .sorted(Comparator.comparing(Point2d::getX))
            .map(p -> new Point2d(p.getX(), Math.abs(p.getY())))
            .toArray(Point2d[]::new));
    }
}

