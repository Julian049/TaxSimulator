package co.edu.uptc.model;

public class Discount {
    
    private String name;
    private float percentage;

    public Discount(String name, float percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public float getPercentage() {
        return percentage;
    }

}
