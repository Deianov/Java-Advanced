//05.Robotics
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // robots
        String input = scanner.nextLine();
        String[] robots = input.split(";");
        int robotsCount = robots.length;

        int[] robotTimes = new int[robotsCount];
        int[] robotSpeeds = new int[robotsCount];

        for (int i = 0; i < robotsCount ; i++) {
            String[] data = robots[i].split("-");
            robots[i] = data[0];
            robotSpeeds[i] = Integer.parseInt(data[1]);
        }

        // current
        Time time = new Time(scanner.nextLine());

        // products
        Deque<String> products = new ArrayDeque<>();

        while (!"End".equals(input = scanner.nextLine())) {
            products.add(input);
        }

        while (!products.isEmpty()) {
            time.plus();

            boolean isAssignment = false;

            for (int i = 0; i < robotsCount ; i++) {

                boolean isFree = --robotTimes[i] < 1;

                if(isFree && !isAssignment) {
                    robotTimes[i] = robotSpeeds[i];
                    System.out.printf("%s - %s %s%n", robots[i], products.poll(), time.toString());
                    isAssignment = true;
                }
            }

            if (!isAssignment) {
                products.offer(products.poll());
            }
        }
    }
}

class Time {
    private int current;

    Time(String timeString) {
        int[] data = Arrays.stream(timeString.split(":")).mapToInt(Integer::parseInt).toArray();
        this.current = (data[0] * 3600) + (data[1] * 60) + data[2];
    }

    void plus() {
        this.current++;
    }

    @Override
    public String toString () {
        int currentTime = this.current;
        int hours = (currentTime / 3600) % 24;
        int remainder = currentTime % 3600;
        int minutes = remainder / 60;
        int seconds = remainder % 60;
        return String.format("[%02d:%02d:%02d]",hours , minutes, seconds);
    }
}
