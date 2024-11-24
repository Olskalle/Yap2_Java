package lab4;

class Storage<T> {
    private T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValueOrAlternative(T alternative) {
        if (alternative == null) 
            throw new IllegalArgumentException("Альтернативное значение не может быть null");

        return (value == null) ? alternative : value;
    }
}