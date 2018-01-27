package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.Local;
import java.util.Map;

@Local
public interface StatisticsRepositoryDao {
    void addVisit(User user);

    Map<User, Integer> getAllStatistics();

    Integer getStatisticsByUser(User user);
}
