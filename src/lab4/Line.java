package lab4;

@SuppressWarnings("unchecked")
class Line<T extends IPoint> implements Cloneable{
    private T start;
    private T end;
    
    public Line(T start, T end) {
        this.start = (T)start.clone();
        this.end = (T)end.clone();
    }

    public T getStart() {
        return start;
    }
    
    public T getEnd() {
        return end;
    }

    public void setStart(T point) {
        start = (T)point.clone();
    }

    public void setEnd(T point) {
        end = (T)point.clone();
    }

    public int getLength() {
        int deltaX = end.getX() - start.getX();
        int deltaY = end.getY() - start.getY();
        
        return (int) Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }

    public void moveStartX(int distance) {
        start.setX(start.getX() + distance);
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

        var other = (Line<T>)obj;

        return this.start.equals(other.getStart()) 
            && this.end.equals(other.getEnd());
    }

    @Override
    public Object clone() {
        return new Line<T>((T)start.clone(), (T)end.clone());
    }
}