package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Persistence {
    private String filename;

    public Persistence(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> loadFile() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename));) {
            String line = "";
            while ((line = buffer.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
