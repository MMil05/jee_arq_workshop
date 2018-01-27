package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.domain.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/car")
@Transactional
public class CarServlet extends HttpServlet {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCar();
        updateCar();
        PrintWriter writer = resp.getWriter();
        writer.println("Car operation processed");
    }

    private void addCar() {
        entityManager.persist(new Car("Bmw x2"));
    }

    private void updateCar() {
        entityManager.createNamedQuery("update")
                .setParameter("model", "Mazda rx")
                .setParameter("modelToUpdate", "Bmw x2")
                .executeUpdate();
    }
}
