package lab5;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class PersonGrouping {
    public static void group(String filename) throws IOException {
        Map<Integer, List<String>> peopleByNumber = Files.lines(Paths.get(filename))
            .map(line -> line.split(":"))
            .filter(parts -> parts.length > 1)
            .map(parts -> new Person(parts[0].trim(), Integer.parseInt(parts[1].trim())))
            .filter(p -> p.getNumber() > 0)
            .collect(Collectors.groupingBy(
                Person::getNumber,
                Collectors.mapping(Person::getName, Collectors.toList())
            ));

        System.out.println(peopleByNumber);
    }
}

class Person {
    private String name;
    private int number;

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}

