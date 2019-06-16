package K_Exams.DemoExam16June2019.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        return this.products.stream().mapToInt(Vegetable::getCalories).sum();
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("* Salad %s is %d calories and have %d products", this.name, getTotalCalories(), getProductCount()));
        for (Vegetable product: this.products) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(product.toString());
        }
        return stringBuilder.toString();
    }
}
