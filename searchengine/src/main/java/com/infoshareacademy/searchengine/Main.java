package com.infoshareacademy.searchengine;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World from " + Main.class.getName() + " !");
        UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean();

        for (User user : usersRepositoryDao.getUsersList()) {
            System.out.println(user.getName());
        }
    }
}
