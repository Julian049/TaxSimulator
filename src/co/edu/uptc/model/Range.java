package co.edu.uptc.model;

public class Range {
    private float percentage;
    private int min;
    private int max;

    public Range(float percentage, int min, int max) {
        this.percentage = percentage;
        this.min = min;
        this.max = max;
    }
    

    public float getPercentage() {
        return percentage;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

}
