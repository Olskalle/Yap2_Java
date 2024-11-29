package lab5;

public class Funs implements Meowable{
    private Meowable item;
    private int meowCount;

    public Funs() {
        meowCount = 0;
    }

    @Override
    public void meow() {
        item.meow();
        meowCount++;
    }

    public void meowCare(Meowable m) {
        item = m;
        meowCount = 0;
    }

    @Override
    public String toString() {
        return "кот мяукал " + meowCount + " раз";
    }
}
