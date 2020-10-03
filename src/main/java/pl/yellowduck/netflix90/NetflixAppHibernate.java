package pl.yellowduck.netflix90;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Category;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.films.VideoCassette;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static pl.yellowduck.netflix90.common.Gender.FEMALE;
import static pl.yellowduck.netflix90.common.Gender.MALE;

public class NetflixAppHibernate {
    static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        System.out.println("\n\n--------------------->\n" +
                "Hibernate Session Factory Created");

        createCategories();
    }

    private static void createCategories() {
        //System.out.println(getOpenInfo());
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // body here
            Category category = new Category("Drama", "Drama movie type");
            session.persist(category);

            category = new Category("Comedy", "Comedy movie type");
            session.persist(category);

            category = new Category("Fantasy", "Fantasy movie type");
            session.persist(category);

            category = new Category("Horror", "Horror movie type");
            session.persist(category);

            category = new Category("Musical", "Musical movie type");
            session.persist(category);

            category = new Category("Action", "Action movie type");
            session.persist(category);

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
