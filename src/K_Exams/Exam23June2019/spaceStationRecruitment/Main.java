package K_Exams.Exam23June2019.spaceStationRecruitment;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        SpaceStation spaceStation = new SpaceStation("Apolo", 10);

        // Initialize entity
        Astronaut astronaut = new Astronaut("Stephen", 40, "Bulgaria");

        // Print Astronaut
        System.out.println(astronaut); // Astronaut: Stephen, 40 (Bulgaria)

        // Add Astronaut
        spaceStation.add(astronaut);

        // Remove Astronaut
        System.out.println(spaceStation.remove("Astronaut name"));

        Astronaut secondAstronaut = new Astronaut("Mark", 34, "UK");
        // Add Astronaut
        spaceStation.add(secondAstronaut);
        Astronaut oldestAstronaut = spaceStation.getOldestAstronaut();
        // Astronaut with name Stephen

        Astronaut astronautStephen = spaceStation.getAstronaut("Stephen");
        // Astronaut with name Stephen

        // Print Astronauts
        System.out.println(oldestAstronaut); // Astronaut: Stephen, 40 (Bulgaria)
        System.out.println(astronautStephen); // Astronaut: Stephen, 40 (Bulgaria)

        System.out.println(spaceStation.getCount()); // 2
        System.out.println(spaceStation.report());

        // Astronauts working at Space Station Apolo:
        // Astronaut: Stephen, 40 (Bulgaria)
        // Astronaut: Mark, 34 (UK)

    }
}
