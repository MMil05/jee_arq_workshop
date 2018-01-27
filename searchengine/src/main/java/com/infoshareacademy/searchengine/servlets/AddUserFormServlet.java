package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class AddUserFormServlet extends HttpServlet {

    protected void setUserData(HttpServletRequest req, User user) {
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setLogin(req.getParameter("login"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        setUserGender(req, user);
    }

    protected void setUserGender(HttpServletRequest req, User user) {
        String gender = req.getParameter("gender");
        if ("MAN".equals(gender)) {
            user.setGender(Gender.MAN);
        } else if ("WOMAN".equals(gender)) {
            user.setGender(Gender.WOMAN);
        } else {
            user.setGender(null);
        }
    }
}
