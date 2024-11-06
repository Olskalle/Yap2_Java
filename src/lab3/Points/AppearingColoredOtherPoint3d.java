package lab3.Points;

public class AppearingColoredOtherPoint3d 
    extends ColoredOtherPoint3d
    implements IAppearable {
    
    protected String time;

    public AppearingColoredOtherPoint3d(int x, String color, String time) {
        super(x, color);
        this.time = time;
    }

    public AppearingColoredOtherPoint3d(int x, int y, String color, String time) {
        super(x, y, color);
        this.time = time;
    }

    public AppearingColoredOtherPoint3d(int x, int y, int z, String color, String time) {
        super(x, y, z, color);
        this.time = time;
    }

    @Override
    public String appearsAt() {
        return time;
    }

    @Override
    public void shouldAppearAt(String appearanceTime) {
        time = appearanceTime;
    }

    @Override
    public String toString() {
        return super.toString() + " в " + time;
    }
}