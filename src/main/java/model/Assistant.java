package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Assistant implements Serializable {

    private String  name;
    private String surname;
    private double averageScore;
    private List<Integer> scores;

    public Assistant(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.scores = new ArrayList<>();
    }

    public void setAverageScore(double score) {
        this.averageScore = score;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
