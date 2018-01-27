package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.StatisticsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
public class StatisticsRepositoryDaoBean implements StatisticsRepositoryDao {

    @EJB
    private StatisticsRepository statisticsRepository;

    @Override
    public void addVisit(User user) {
        statisticsRepository.getRepository().putIfAbsent(user, 0);
        Integer userStats = getStatisticsByUser(user);
        statisticsRepository.getRepository().replace(user, userStats + 1);
    }

    @Override
    public Map<User, Integer> getAllStatistics() {
        return statisticsRepository.getRepository();
    }

    @Override
    public Integer getStatisticsByUser(User user) {
        return statisticsRepository.getRepository().getOrDefault(user, 0);
    }
}