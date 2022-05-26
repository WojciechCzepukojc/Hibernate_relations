package pl.sda.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class StudentMain {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student(null, "Jan", "Kowalski", LocalDate.of(1999,6,17), null);
        StudentIndex studentIndex = new StudentIndex(null, "45451236", student );
        student.setStudentIndex(studentIndex);

        session.save(student);
        session.save(studentIndex);

        StudentIndex studentIndexFromDB = session.get(StudentIndex.class, 1);

        System.out.println("Surmame for Student with id =1 : " + studentIndexFromDB.getStudent().getSurname());

        Student student1 = session.get(Student.class, 1);
        System.out.println("Index number for Student with id =1 : " + student1.getStudentIndex().getNumber());


        transaction.commit();
        session.close();
        sessionFactory.close();


    }

}
