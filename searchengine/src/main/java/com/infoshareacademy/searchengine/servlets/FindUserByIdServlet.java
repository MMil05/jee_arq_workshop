package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.cdibeans.MaxPulse;
import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @EJB
    StatisticsRepositoryDao statisticsRepositoryDao;

    @Inject
    MaxPulse maxPulseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        User user = usersRepositoryDao.getUserById(id);

        if (user != null) {
            statisticsRepositoryDao.addVisit(user);
        }

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(user.getName());
        printWriter.println(statisticsRepositoryDao.getStatisticsByUser(user));

        if (user.getGender() == Gender.MAN) {
            printWriter.println(maxPulseBean.calculateMaxPulseForMen(user.getAge()));
        } else if (user.getGender() == Gender.WOMAN) {
            printWriter.println(maxPulseBean.calculateMaxPulseForWomen(user.getAge()));
        }
    }
}
