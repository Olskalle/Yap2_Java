package lab5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ConsonantsExtractor {
    private static final String voicedConsonants = "бвгджзлмнр";
    
    public static void extract(String filename) {
        Set<Character> consonants = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;

            // Read lines from the file
            while ((line = reader.readLine()) != null) {
                for (char c : line.toLowerCase().toCharArray()) {
                    // Check if the character is a voiced consonant and add it to the set
                    if (voicedConsonants.indexOf(c) >= 0) {
                        consonants.add(c);
                    }
                }
            }

            consonants.forEach(System.out::print);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println();
    }
}

