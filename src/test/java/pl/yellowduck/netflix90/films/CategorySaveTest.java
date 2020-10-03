package pl.yellowduck.netflix90.films;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CategorySaveTest {


    @Test
    public void SaveDirector() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();


        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            Category category = new Category("Thriller", "Thriller movie type");
            session.persist(category);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null && !tx.getRollbackOnly()) {
                tx.rollback();
            }
            throw ex;
        }
    }
}
