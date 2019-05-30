package F_DefiningClasses.Exercises.E05;

import java.util.HashMap;

class Engine {
    static HashMap<String, Engine> engines = new HashMap<>();

    private String model;
    private int power;
    private Integer displacement = null;
    private String efficiency = null;

    Engine(String model, int power) {
        this.model = model;
        this.power = power;

        Engine.engines.put(this.model, this);
    }

    Engine(String model, int power, Integer displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    Engine(String model, int power, Integer displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return
                String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n",
                        this.model,
                        this.power,
                        this.displacement == null ? Default.UNDEFINED_VALUE : this.displacement + "",
                        this.efficiency == null ? Default.UNDEFINED_VALUE : this.efficiency);
    }
}
