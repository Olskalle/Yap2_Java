package lab6.annotations;

@ToString(value = "NO")
public class ToStringSample {
    @ToString(value = "YES")
    private String myField;

    private int myInt;
}