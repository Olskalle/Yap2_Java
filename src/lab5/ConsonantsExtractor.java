package lab5;

import java.io.*;
import java.util.*;

public class ConsonantsExtractor {
    static final String voicedConsonants = "бвгджзлмнр";
    
    public static void extract(String filename) throws IOException {
        Set<Character> consonants = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;


        while ((line = reader.readLine()) != null) {
            for (char c : line.toLowerCase().toCharArray()) {
                if (voicedConsonants.indexOf(c) >= 0) {
                    consonants.add(c);
                }
            }
        }

        consonants.forEach(System.out::println);
        reader.close();
    }
}

