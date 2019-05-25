//11. Logs Aggregator
package C_SetsAndMaps.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();

        Pattern pattern = Pattern.compile("(?<ip>\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s+(?<user>[a-zA-Z]+[\\s]*[a-zA-Z]*)\\s+(?<duration>\\d+)");

        while (n-- > 0) {

            Matcher matcher = pattern.matcher(scanner.nextLine());

            if (matcher.find()) {

                String ip = matcher.group("ip");
                String user = matcher.group("user");
                int duration = Integer.parseInt(matcher.group("duration"));

                logs.putIfAbsent(user, new TreeMap<>());
                logs.get(user).putIfAbsent(ip, 0);
                logs.get(user).put(ip, logs.get(user).get(ip) + duration);
            }
        }

        logs.forEach((key, value) -> {
            int duration = value.values().stream().mapToInt(Integer::intValue).sum();
            String ips = value.keySet().toString();
            System.out.printf("%s: %d %s%n",key, duration, ips);
        });
    }
}