package pl.yellowduck.netflix90.resources;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.Actor;


public class ActorTest {
    @Test public void saveActor() {
       SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Actor.class)
                .buildSessionFactory();
        //System.out.println(getOpenInfo());
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            // body her
            Actor actor = new Actor("Jan", "Kowalski", Gender.MALE);
            session.persist(actor);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null && !tx.getRollbackOnly()) {
                tx.rollback();
            }
            throw ex;
        }
        //System.out.println(getCloseInfo());
    }
}
