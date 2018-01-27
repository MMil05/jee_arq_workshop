package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id-obj")
public class FindUserByIdServletNoBean extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));

        UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean();
        User user = usersRepositoryDao.getUserById(id);

        if (user == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(user.getName());
    }
}
