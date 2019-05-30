package F_DefiningClasses.Exercises.E06;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Trainer {
    static LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

    private String name;
    private int badges;
    private HashMap<String, Pokemon> pokemons;

    Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new HashMap<>();
    }

    public String getName() { return name; }
    public int getBadges() { return badges; }
    public HashMap<String, Pokemon> getPokemons() { return pokemons; }

    void addPokemon(String name, String element, int health) {
        this.pokemons.put(name, new Pokemon(name, element, health));
    }

    boolean containPokemon (String element) {

        if (this.pokemons.values().stream().anyMatch(e -> e.getElement().equals(element))) {
            this.badges++;
            return true;
        }
        return false;
    }

    void loseHealth() {

        // filter dead pokemons
        this.pokemons = this.pokemons
                .entrySet()
                .stream()
                .filter(e -> e.getValue().lossHealth())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,HashMap::new));
    }

}
