package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Assistant implements Serializable {

    private String  name;
    private String surname;
    private double averageScore;
    private List<Integer> scores;

    public Assistant() {
        this.scores = new ArrayList<>();
    }

    private void setAverageScore(double score) {
        this.averageScore = score;
    }

    private double getAverageScore() {
        return averageScore;
    }

    private List<Integer> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
