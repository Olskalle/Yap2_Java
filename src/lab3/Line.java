package lab3;

class Line {
    private Point start;
    private Point end;
    
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }
    
    public Line(int startX, int startY, int endX, int endY) {
        start = new Point(startX, startY);
        end = new Point(endX, endY);
    }

    public Point getStart() {
        return start;
    }
    
    public Point getEnd() {
        return end;
    }

    public void setStart(Point point) {
        start = new Point(point.getX(), point.getY());
    }

    public void setEnd(Point point) {
        end = new Point(point.getX(), point.getY());
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