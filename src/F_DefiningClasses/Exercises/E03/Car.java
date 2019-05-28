package F_DefiningClasses.Exercises.E03;

class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int traveled;

    Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.traveled = 0;
    }

    String getModel() { return model; }

    void drive(int distance) {
        if ((distance * this.fuelCost) <= this.fuelAmount) {
            this.traveled+= distance;
            this.fuelAmount = this.fuelAmount - (distance * this.fuelCost);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    void print() {
        System.out.println(String.format("%s %.2f %d", this.model, this.fuelAmount, this.traveled));
    }
}
