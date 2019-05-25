//09. User Logs
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        Pattern pattern = Pattern.compile("^IP=(?<ip>.*) message=.* user=(?<user>.*)$");

        while (!"end".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String ip = matcher.group("ip");
                String user = matcher.group("user");

                users.putIfAbsent(user, new LinkedHashMap<>());
                users.get(user).putIfAbsent(ip, 0);
                users.get(user).put(ip, users.get(user).get(ip) + 1);
            }
        }

        users.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            int index = 0;
            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                System.out.printf("%s%s => %d", index++ == 0 ? "" : ", ", entry.getKey(), entry.getValue());
            }
            System.out.printf(".%n");
        });
    }
}
