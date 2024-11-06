package ru.zolnikov.lab2.geometry;

public class LineSimple {
    private PointSimple start;
    private PointSimple end;

    public void setStart(int startX, int startY) {
        start.setX(startX);
        start.setY(startY);
    }

    public void setEnd(int endX, int endY) {
        end.setX(endX);
        end.setY(endY);
    }

    public void setStart(PointSimple start) {
        this.start = start;
    }

    public void setEnd(PointSimple end) {
        this.end = end;
    }

    public PointSimple getStart () {
        return start;
    }

    public PointSimple getEnd() {
        return end;
    }

    public LineSimple() {
        start = new PointSimple();
        end = new PointSimple();
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}