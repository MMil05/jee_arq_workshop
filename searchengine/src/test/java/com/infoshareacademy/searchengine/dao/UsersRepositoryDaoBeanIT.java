package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.Phone;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.interceptors.AddUserInterceptor;
import com.infoshareacademy.searchengine.interceptors.AddUserSetGenderInterceptor;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.infoshareacademy.searchengine.domain.Gender.MAN;
import static com.infoshareacademy.searchengine.domain.Gender.WOMAN;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class UsersRepositoryDaoBeanIT {

    @EJB
    private UsersRepositoryDao usersRepositoryDao;
    @PersistenceContext(name = "pUnit")
    private EntityManager em;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(AddUserSetGenderInterceptor.class,
                        AddUserInterceptor.class,
                        User.class, Gender.class, Phone.class,
                        UsersRepository.class,
                        UsersRepositoryDao.class,
                        UsersRepositoryDaoRemote.class,
                        UsersRepositoryDaoBean.class)
                // addAsResource - gdy WAR
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
                // gdy JAR:
              //  .addAsManifestResource("test-persistence.xml", "persistence.xml");
    }

    @Test
    @InSequence(1)
    public void addUser() throws Exception {
        User user = new User();
        user.setName("Adam");
        user.setSurname("Nowak");
        usersRepositoryDao.addUser(user);

        List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        List<User> userList = usersRepositoryDao.getUsersList();

        // czy user został faktycznie dodany do bazy danych
        assertThat(userList.size(), is(1));
        // czy interceptor ustawił poprawną płeć
        assertTrue(user.getGender().equals(MAN));
        // sprawdzić czy metoda getUsersList faktycznie zwraca zawartość bazy danych
        assertTrue(user.getSurname().equals(userList.get(0).getSurname())
            && user.getName().equals(userList.get(0).getName())
        );
        assertThat(userList.get(0).getId(), is(1));
    }



}