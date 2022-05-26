package pl.sda.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ClientMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Order order1 = new Order(null, BigDecimal.valueOf(100.34), "woda", LocalDateTime.now(),null);
        Order order2 = new Order(null, BigDecimal.valueOf(563.34), "słodycze", LocalDateTime.now(), null);

        Client client = new Client(null, "nick", Arrays.asList(order1,order2));

        order1.setClient(client);
        order2.setClient(client);

        session.save(order1);
        session.save(order2);
        session.save(client);

        Client client1 = session.get(Client.class, 1);

//        session.remove(client);
//        client.getOrders().forEach(o -> System.out.println(o.getProducts()));


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
