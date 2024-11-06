package lab3;
import java.util.Arrays;

public class ImmutableArray {
    private final int[] values;

    public ImmutableArray(int... values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public ImmutableArray(ImmutableArray other) {
        this.values = Arrays.copyOf(other.values, other.values.length);
    }

    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throwOutOfBounds(index);
        }
        return values[index];
    }

    public ImmutableArray withValueAt(int index, int newValue) {
        if (index < 0 || index >= values.length) {
            throwOutOfBounds(index);
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = newValue;
        return new ImmutableArray(newValues);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int size() {
        return values.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    private void throwOutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Индекс находился за границами массива: " + index + ", размер массива: " + values.length);
    }
}