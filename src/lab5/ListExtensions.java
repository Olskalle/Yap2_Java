package lab5;

import java.util.List;
import java.util.Iterator;

public class ListExtensions {
    public static <T> void removeAllEntries(List<T> list, T element) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                iterator.remove();
            }
        }
    }
}

