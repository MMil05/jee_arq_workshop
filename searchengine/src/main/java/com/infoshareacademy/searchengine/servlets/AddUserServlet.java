package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-user")
public class AddUserServlet extends AddUserFormServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUser(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addUser(req, resp);
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();

        setUserData(req, user);
        addUserIfValid(req, resp, user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addUserIfValid(HttpServletRequest req, HttpServletResponse resp, User user) {
        if (!usersRepositoryDao.addUser(user)) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            req.setAttribute("errorMessage", "User with this ID exists.");
        } else {
            req.setAttribute("okMessage", "User " + user.getName() + " has been added.");
        }
    }
}
