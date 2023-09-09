package co.edu.uptc.model;

import java.util.ArrayList;

public class Brand {
    
    private String name;
    private ArrayList<Line> lines;

    public Brand(String name) {
        this.name = name;
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }   

    public void addModel(Line line, Model model){
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(line.getName())) {
                lines.get(i).addModel(model);
            }
        }
    }
    
    public String getName() {
        return name;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

}
