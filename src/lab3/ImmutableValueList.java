package lab3;
import java.util.Arrays;

public class ImmutableValueList {
    private final int[] values;

    // Конструктор с перечислением значений
    public ImmutableValueList(int... values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    // Конструктор для копирования другого списка
    public ImmutableValueList(ImmutableValueList other) {
        this.values = Arrays.copyOf(other.values, other.values.length);
    }

    // Получение значения из позиции
    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throwOutOfBounds(index);
        }
        return values[index];
    }

    // Замена значения в позиции (выкидываем исключение, так как это неизменяемый список)
    public ImmutableValueList withValueAt(int index, int newValue) {
        if (index < 0 || index >= values.length) {
            throwOutOfBounds(index);
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = newValue;
        return new ImmutableValueList(newValues);
    }

    // Приведение к строке
    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return values.length == 0;
    }

    // Получение текущего размера
    public int size() {
        return values.length;
    }

    // Получение значений в виде стандартного массива
    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    private void throwOutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Индекс находился за границами массива: " + index + ", размер массива: " + values.length);
    }

    // Пример использования
    public static void main(String[] args) {
        ImmutableValueList list1 = new ImmutableValueList(new int[]{1, 2, 3});
        System.out.println("List1: " + list1); // [1, 2, 3]

        ImmutableValueList list2 = new ImmutableValueList(4, 5, 6);
        System.out.println("List2: " + list2); // [4, 5, 6]

        ImmutableValueList list3 = new ImmutableValueList(list1);
        System.out.println("List3 (copied from List1): " + list3); // [1, 2, 3]

        System.out.println("Get value at index 1 from List1: " + list1.get(1)); // 2
        System.out.println("Size of List1: " + list1.size()); // 3
        System.out.println("Is List1 empty? " + list1.isEmpty()); // false

        // Показать, как создать новый список с изменением значения
        ImmutableValueList list4 = list1.withValueAt(1, 99);
        System.out.println("List4 (new value at index 1): " + list4); // [1, 99, 3]
        System.out.println("List1 remains unchanged: " + list1); // [1, 2, 3]
    }
}