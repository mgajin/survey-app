package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private List<Assistant> assistants;

    public Database() {
        this.assistants = new ArrayList<>();
    }

    private List<Assistant> getAssistants() {
        return this.assistants;
    }

    private Assistant getAssistant(String name, String surname) {

        for (Assistant assistant : this.assistants) {
            if (assistant.getName().equals(name) && assistant.getSurname().equals(surname)) {
                return assistant;
            }
        }
        return null;
    }

}
