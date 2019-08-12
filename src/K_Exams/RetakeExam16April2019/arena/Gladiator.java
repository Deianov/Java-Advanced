package K_Exams.RetakeExam16April2019.arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getStatPower(){
        return  stat.getAgility() +
                stat.getFlexibility() +
                stat.getIntelligence() +
                stat.getSkills() +
                stat.getStrength();
    }

    public int getWeaponPower() {
        return  weapon.getSharpness() +
                weapon.getSize() +
                weapon.getSolidity();
    }

    public int getTotalPower() {
        return this.getStatPower() + this.getWeaponPower();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(System.lineSeparator())
                .append(String.format("%s - %d", this.getName(), this.getTotalPower()))
                .append(System.lineSeparator())
                .append(String.format("  Weapon Power: %d", this.getWeaponPower()))
                .append(System.lineSeparator())
                .append(String.format("  Stat Power: %d", this.getStatPower()));
        return stringBuilder.toString().trim();
    }
}
