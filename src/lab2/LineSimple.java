package lab2;

class LineSimple {
    public PointSimple Start;
    public PointSimple End;

    @Override
    public String toString() {
        return "Линия от " + Start + " до " + End;
    }
}