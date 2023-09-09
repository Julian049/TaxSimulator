package co.edu.uptc.model;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Model> models;

    public Line(String name) {
        this.name = name;
        this.models = new ArrayList<>();
    }

    public void addModel(Model model) {
        models.add(model);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Model> getModels() {
        return models;
    }
}
