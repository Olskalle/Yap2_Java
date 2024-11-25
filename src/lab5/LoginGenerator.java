package lab5;

import java.util.*;

public class LoginGenerator {
    public static void generate() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        Map<String, Integer> loginMap = new HashMap<>();
        List<String> logins = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String fullName = scanner.nextLine();
            String[] parts = fullName.split(" ");
            String surname = parts[0];

            loginMap.put(surname, loginMap.getOrDefault(surname, 0) + 1);
            String login = (loginMap.get(surname) == 1) ? surname : surname + loginMap.get(surname);
            logins.add(login);
        }

        logins.forEach(login -> System.out.println(login));
        scanner.close();
    }
}

