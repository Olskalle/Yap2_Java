package lab6;

public class SampleClass implements ForCaching{
    private String stringField;

    public SampleClass(String str) { 
        stringField = str;
    }

    public int cacheTest () {
        System.out.println("original method");
        return 42;
    }

    @Override
    public void setStringField(String value) {
        stringField = value;
    }
}
