package pl.yellowduck.netflix90.films;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;

public class DirectorSaveTest {

    @Test
    public void SaveDirector(){

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Director.class)
                .buildSessionFactory();


        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Director director = new Director();
            director.setId(1L);
            director.setFirstname("Jan");
            director.setLastname("Kowalski");
            director.setGender(Gender.MALE);
            session.save(director);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null && !tx.getRollbackOnly()) {
                tx.rollback();
            }
            throw ex;
        }
    }
}
