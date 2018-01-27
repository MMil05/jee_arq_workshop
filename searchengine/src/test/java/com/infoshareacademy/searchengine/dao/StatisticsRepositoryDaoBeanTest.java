package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.Phone;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.StatisticsRepository;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

@RunWith(Arquillian.class)
public class StatisticsRepositoryDaoBeanTest {

    @EJB
    private StatisticsRepositoryDao repositoryDaoBean;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(
                        StatisticsRepositoryDaoBean.class,
                        StatisticsRepository.class, StatisticsRepositoryDao.class,
                        UsersRepository.class,
                        User.class, Gender.class, Phone.class
                )
                .addAsManifestResource("test-persistence.xml", "persistence.xml");
    }

    @Test
    public void testAddUserVisit() throws Exception {
        repositoryDaoBean.addVisit(new User());
    }
}