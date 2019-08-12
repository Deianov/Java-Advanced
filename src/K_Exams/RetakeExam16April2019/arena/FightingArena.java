package K_Exams.RetakeExam16April2019.arena;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FightingArena {
    private Map<String, Gladiator> gladiators;
    private String name;

    public FightingArena( String name) {
        this.gladiators = new LinkedHashMap<>();
        this.name = name;
    }

    public void add(Gladiator gladiator){
        if (gladiator != null){
            gladiators.putIfAbsent(gladiator.getName(), gladiator);
        }
    }

    public void remove(String name) {
        if (name != null){
            gladiators.remove(name);
        }
    }

    public Gladiator getGladiatorWithHighestStatPower(){
        return this.gladiators.values().stream()
                .max(Comparator.comparingInt(Gladiator::getStatPower))
                .orElse(null);
    }

    public Gladiator getGladiatorWithHighestWeaponPower(){
        return this.gladiators.values().stream()
                .max(Comparator.comparingInt(Gladiator::getWeaponPower))
                .orElse(null);
    }

    public Gladiator getGladiatorWithHighestTotalPower(){
        return this.gladiators.values().stream()
                .max(Comparator.comparingInt(Gladiator::getTotalPower))
                .orElse(null);
    }

    public int  getCount(){
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format(
                "%s – %d gladiators are participating.",
                this.name,
                this.getCount());
    }
}
