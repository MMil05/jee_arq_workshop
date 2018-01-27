package com.infoshareacademy.searchengine.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        req.setAttribute("salary", req.getAttribute("salary"));
        req.setAttribute("name", req.getParameter("name"));
        req.getSession().setAttribute("sessionName", req.getParameter("name"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/welcome-user.jsp");
        requestDispatcher.forward(req, resp);
    }
}
