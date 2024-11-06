package ru.zolnikov.lab2.geometry;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int startX, int startY, int endX, int endY) {
        start = new Point(startX, startY);
        end = new Point(endX, endY);
    }

    public void setStart(Point point) {
        start = point;
    }

    public void setEnd(Point point) {
        end = point;
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
}