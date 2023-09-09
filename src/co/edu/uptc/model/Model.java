package co.edu.uptc.model;

public class Model {
    private int year;
    private int value;

    public Model(int year, int value) {
        this.year = year;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}
