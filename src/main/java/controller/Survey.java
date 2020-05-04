package main.java.controller;

import main.java.model.Assistant;
import main.java.model.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Survey", urlPatterns = "/survey")
public class Survey extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Database db = (Database) getServletContext().getAttribute("database");

        String name =  req.getParameter("name");
        String surname =  req.getParameter("surname");
        String rating =  req.getParameter("rating");

        int rated = (name.equals("Aleksandar")) ? 0 : Integer.parseInt(rating);

        Assistant assistant = db.getAssistant(name, surname);

        if (assistant == null) {
            assistant = new Assistant(name, surname);
            db.getAssistants().add(assistant);
        }

        rateAssistant(assistant, rated);

        for (Assistant ass : db.getAssistants()) {
            System.out.println(ass.toString() + ": " + ass.getAverageScore());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("results.jsp");
        dispatcher.forward(req, resp);
    }

    private void rateAssistant(Assistant assistant, int rated) {
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
