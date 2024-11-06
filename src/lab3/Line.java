package lab3;

import lab3.Points.Point2d;

class Line {
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
}