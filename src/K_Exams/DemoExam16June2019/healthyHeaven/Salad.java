package K_Exams.DemoExam16June2019.healthyHeaven;

import java.util.LinkedHashMap;

public class Salad {
    private String name;
    private LinkedHashMap<String, Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        return
                this.products.values().stream().mapToInt(Vegetable::getCalories).sum();
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        if (product == null)
            return;

        this.products.put(product.getName().toLowerCase(), product);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("* Salad %s is %d calories and have %d products:", this.name, getTotalCalories(), getProductCount()));
        for (Vegetable product: this.products.values()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(product.toString());
        }
        return stringBuilder.toString().trim();
    }
}
