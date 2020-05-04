package main.java.controller;

import main.java.model.Assistant;
import main.java.model.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Survey", urlPatterns = "/survey")
public class Survey extends HttpServlet {

    private Database db = new Database();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session = req.getSession();

        String name =  req.getParameter("name");
        String surname =  req.getParameter("surname");
        String rating =  req.getParameter("rating");

        Assistant assistant = db.getAssistant(name, surname);

        if (assistant != null) {
            int rated = (assistant.getName().equals("Aleksandar")) ? 0 : Integer.parseInt(rating);
            rateAssistant(assistant, rated);
        } else {
            assistant = new Assistant(name, surname);
            assistant.getScores().add(Integer.parseInt(rating));
            assistant.setAverageScore(Double.parseDouble(rating));
            db.getAssistants().add(assistant);
        }

        System.out.println(assistant.toString() + ": " + assistant.getAverageScore());
    }

    private void rateAssistant(Assistant assistant, int rated) {
//        System.out.println(rated);
        List<Integer> ratings = assistant.getScores();
        ratings.add(rated);
        int n = ratings.toArray().length;
        double avg = 0;
        for (int rating : ratings) {
            avg += rating;
        }
        avg /= n;
        assistant.setAverageScore(avg);
    }
}
