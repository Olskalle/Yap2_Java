package lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenericMethods {
    public static <T, P> List<P> apply(List<T> list, ApplyFunction<T, P> func) {
        if (list == null || list.isEmpty())
            return List.of();

        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(func.apply(item));
        }
        return result;
    }

    public static <T> T reduce(List<T> list, BinaryOperator<T> accumulator, T defaultValue) {
        if (list == null || list.isEmpty())
            return defaultValue;
        
        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = accumulator.apply(result, list.get(i));
        }
        return result;
    }

    public static <T, K> Map<K, List<T>> collect(List<T> sourceList, Function<T, K> keyExtractor) {
        
        Map<K, List<T>> groupedMap = new HashMap<>();
        for (T item : sourceList) {
            K key = keyExtractor.apply(item);
            
            groupedMap.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }
        return groupedMap;
    }

    public static <T, P extends Collection<T>> P collectToType(
            List<T> sourceList, 
            Supplier<P> collectionSupplier) {
        
        P resultCollection = collectionSupplier.get();
        resultCollection.addAll(sourceList);
        return resultCollection;
    }
}