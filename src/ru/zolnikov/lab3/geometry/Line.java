package ru.zolnikov.lab3.geometry;

import ru.zolnikov.lab3.geometry.points.Point2d;

public class Line implements Cloneable{
    private Point2d start;
    private Point2d end;
    
    public Line(Point2d start, Point2d end) {
        this.start = new Point2d(start.getX(), start.getY());
        this.end = new Point2d(end.getX(), end.getY());
    }
    
    public Line(int startX, int startY, int endX, int endY) {
        start = new Point2d(startX, startY);
        end = new Point2d(endX, endY);
    }

    public Point2d getStart() {
        return start;
    }
    
    public Point2d getEnd() {
        return end;
    }

    public void setStart(Point2d point) {
        start = new Point2d(point.getX(), point.getY());
    }

    public void setEnd(Point2d point) {
        end = new Point2d(point.getX(), point.getY());
    }

    public int getLength() {
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();
        
        return (int) Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        
            if (obj == null || getClass() != obj.getClass()) 
            return false;

        var other = (Line)obj;

        return this.start.equals(other.getStart()) 
            && this.end.equals(other.getEnd());
    }

    @Override
    public Object clone() {
        return new Line((Point2d)start.clone(), (Point2d)end.clone());
    }
}