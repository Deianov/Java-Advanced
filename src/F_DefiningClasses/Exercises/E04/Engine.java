package F_DefiningClasses.Exercises.E04;

class Engine {
    private int engineSpeed;
    private int enginePower;

    Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    int getEnginePower() { return enginePower; }
}
