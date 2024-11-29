package lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LoginGenerator {
    public static void generate(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            int N = Integer.parseInt(reader.readLine());

            Map<String, Integer> loginMap = new HashMap<>();
            List<String> logins = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String fullName = reader.readLine();
                String[] parts = fullName.split(" ");
                String surname = parts[0];

                loginMap.put(surname, loginMap.getOrDefault(surname, 0) + 1);

                String login = (loginMap.get(surname) == 1) ? surname : surname + loginMap.get(surname);
                logins.add(login);
            }

            logins.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

