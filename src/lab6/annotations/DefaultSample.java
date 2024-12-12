package lab6.annotations;

@Default(value = String.class)
public class DefaultSample {
    @Default(value = Integer.class)
    private int someField;
}