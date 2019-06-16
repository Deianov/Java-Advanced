package K_Exams.DemoExam16June2019.healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> salads;

    public Restaurant(String name) {
        this.name = name;
        this.salads = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.salads.add(salad);
    }

    public boolean buy(String name) {
        for (int i = 0; i < salads.size(); i++) {

            Salad salad = salads.get(i);

            if (salad.getName().equals(name)) {

                this.salads.remove(salad);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
       return salads.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);
    }

    public String generateMenu() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s have %d salads:", this.name, this.salads.size()));
        for (Salad salad: salads) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(salad.toString());
        }
        return stringBuilder.toString();
    }

}
