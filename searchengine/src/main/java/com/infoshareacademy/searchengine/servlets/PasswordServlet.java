package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import org.jboss.crypto.CryptoUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hash-password")
public class PasswordServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hashedPassword = CryptoUtil.createPasswordHash("MD5", "hex", null, null, req.getParameter("password"));
        resp.getWriter().println(hashedPassword);
    }
}
