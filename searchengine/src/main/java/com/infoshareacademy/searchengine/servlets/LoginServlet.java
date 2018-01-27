package com.infoshareacademy.searchengine.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.login(req.getParameter("j_username"), req.getParameter("j_password"));
        } catch (ServletException e) {
            req.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        if (req.getHeader("Referer").contains("login.jsp")) {
            resp.sendRedirect("/index.jsp");
            return;
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
