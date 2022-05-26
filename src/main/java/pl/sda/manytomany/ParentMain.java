package pl.sda.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class ParentMain {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Parent parent1 = new Parent(null, "Jan", "Kowalski", null);
        Parent parent2 = new Parent(null, "Anna", "Kowalska", null);

        Child child1 = new Child(null, "Michał", "Kowalski");
        Child child2 = new Child(null, "Kasia", "Kowalska");

        parent1.setChildren(Arrays.asList(child1, child2));
        parent2.setChildren(Arrays.asList(child1, child2));

        session.save(child1);
        session.save(child2);
        session.save(parent1);
        session.save(parent2);

        Parent parentFromDB = session.get(Parent.class, 1);
        parentFromDB.getChildren().forEach(c -> System.out.println(c.getFirstName()));

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}

