//05.Robotics
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // robots
        String input = scanner.nextLine();
        Deque<Robot> robots = new ArrayDeque<>();
        // time
        Time time = new Time(scanner.nextLine());

        for (String robot : input.split(";")) {
            String[] data = robot.split("-");
            String name = data[0];
            int speed = Integer.valueOf(data[1]);
            robots.add(new Robot(name, speed, time));
        }

        Deque<String> products = new ArrayDeque<>();

        while (!"End".equals(input = scanner.nextLine())) {
            products.add(input);
        }

        while (!products.isEmpty()) {
            time.plus();

            Robot robot = robots.stream().filter(Robot::isFree).findFirst().orElse(null);

            if (robot != null) {
                robot.setJob(time.current());
                System.out.printf("%s - %s %s%n", robot.getName(), products.poll(), time.toString());
            } else {
                products.add(products.poll());
            }
        }
    }
}

class Time {
    private int time;

    Time(String timeString) {
        String[] data = timeString.split(":");
        int time = 0;
        time += Integer.valueOf(data[0]) * 3600;
        time += Integer.valueOf(data[1]) * 60;
        time += Integer.valueOf(data[2]);
        this.time = time;
    }

    void plus() {
        this.time += 1;
    }

    int current() {
        return this.time;
    }

    @Override
    public String toString () {
        int currentTime = this.time;
        currentTime = currentTime % 86400;
        int hours = currentTime / 3600;
        currentTime -= hours * 3600;
        int minutes = currentTime / 60;
        currentTime -= minutes * 60;
        int seconds = currentTime;

        return String.format("[%02d:%02d:%02d]",hours , minutes, seconds);
    }
}

class Robot {
    private String name;
    private int speed;
    private int startTime;
    private Time time;

    Robot(String name, int speed, Time time) {
        this.name = name;
        this.speed = speed;
        this.startTime = 0;
        this.time = time;
    }

    void setJob(int startTime) {
        this.startTime = startTime;
    }

    String getName() {
        return name;
    }

    boolean isFree () {
        return (this.startTime + this.speed) <= this.time.current();
    }
}
