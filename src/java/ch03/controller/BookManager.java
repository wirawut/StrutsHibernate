package ch03.controller;

import ch03.model.Book;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//ถูก BookAction เรียกใช้
public class BookManager {

    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println(e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public List<Book> list() {
        final Session session = factory.openSession();
        session.beginTransaction();

		@SuppressWarnings("unchecked")
        final List<Book> books = session.createQuery("FROM Book").list();
        session.getTransaction().commit();
        return books;
    }

    /*
    public Book add(Book book) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        return book;
    } */
}