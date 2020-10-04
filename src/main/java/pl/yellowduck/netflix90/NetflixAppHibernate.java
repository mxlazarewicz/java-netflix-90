package pl.yellowduck.netflix90;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Category;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.films.VideoCassette;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static pl.yellowduck.netflix90.common.Gender.FEMALE;
import static pl.yellowduck.netflix90.common.Gender.MALE;

public class NetflixAppHibernate {
    static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(VideoCassette.class)
                .buildSessionFactory();

        System.out.println("\n\n--------------------->\n" +
                "Hibernate Session Factory Created");

        //createCategories();
        //createDirectors();
        //createActors();
        createCassettes();
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

    private static void createDirectors() {
        //System.out.println(getOpenInfo());
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // body here
            Director director = new Director("Tommy", "Wiseau", Gender.MALE);
            session.persist(director);

            director = new Director("Sidney", "Pollack", Gender.MALE);
            session.persist(director);

            director = new Director("Clint", "Eastwood", Gender.MALE);
            session.persist(director);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null && !tx.getRollbackOnly()) {
                tx.rollback();
            }
            throw ex;
        }
        //System.out.println(getCloseInfo());
    }

    private static void createActors() {
        //System.out.println(getOpenInfo());
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // body here
            Actor tommyActor = new Actor("Tommy", "Wiseau", Gender.MALE);
            session.persist(tommyActor);

            Actor juliette = new Actor("Juliette", "Danielle", Gender.FEMALE);
            session.persist(juliette);

            Actor greg = new Actor("Greg", "Sestero", Gender.MALE);
            session.persist(greg);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null && !tx.getRollbackOnly()) {
                tx.rollback();
            }
            throw ex;
        }
        //System.out.println(getCloseInfo());
    }


    private static void createCassettes() {
        //System.out.println(getOpenInfo());
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // body here

            Category drama = new Category("Drama", "Drama movie type");
            session.persist(drama);

            Category category = new Category("Comedy", "Comedy movie type");
            session.persist(category);

            category = new Category("Fantasy", "Fantasy movie type");
            session.persist(category);

            category = new Category("Horror", "Horror movie type");
            session.persist(category);

            category = new Category("Musical", "Musical movie type");
            session.persist(category);

            category = new Category("Action", "Action movie type");
            session.persist(category);

            Director tommyDirector = new Director("Tommy", "Wiseau", Gender.MALE);
            session.persist(tommyDirector);

            Director director = new Director("Sidney", "Pollack", Gender.MALE);
            session.persist(director);

            director = new Director("Clint", "Eastwood", Gender.MALE);
            session.persist(director);

            Actor tommyActor = new Actor("Tommy", "Wiseau", Gender.MALE);
            session.persist(tommyActor);

            Actor juliette = new Actor("Juliette", "Danielle", Gender.FEMALE);
            session.persist(juliette);

            Actor greg = new Actor("Greg", "Sestero", Gender.MALE);
            session.persist(greg);

            BigDecimal price = new BigDecimal(100);

            Set<Actor> actors = new HashSet<>();
            actors.add(tommyActor);
            actors.add(juliette);
            actors.add(greg);

            VideoCassette videoCassette = new VideoCassette(price, "The Room", tommyDirector, category, actors);
            session.persist(videoCassette);

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
