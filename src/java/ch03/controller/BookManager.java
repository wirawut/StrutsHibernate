package ch03.controller;

import ch03.model.Book;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

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

    public Book add(Book book) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        return book;
    }

    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = (Book) session.load(Book.class, id);
        session.delete(book);
        session.getTransaction().commit();
    }

    public Book find(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = (Book) session.load(Book.class, id);
        session.getTransaction().commit();
        return book;
    }

    public void update(Book book) {
        Session session = factory.openSession();
        session.beginTransaction();

        session.update(book);
        session.getTransaction().commit();
        session.close();
    }

    public List where() {
        Session session = factory.openSession();
        session.beginTransaction();

        List books = session.createQuery("FROM Book WHERE page=300").list();
        session.getTransaction().commit();
        return books;
    }

    public List limit() {
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Book");
        query.setFirstResult(1);
        query.setMaxResults(3);

        List books = query.list();
        session.getTransaction().commit();
        return books;
    }

    public Book sumMaxMin() {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Book.class);
        
        criteria.setProjection(Projections.max("price"));
        int max = Integer.parseInt(criteria.uniqueResult().toString());

        criteria.setProjection(Projections.max("price"));
        int min = Integer.parseInt(criteria.uniqueResult().toString());

        criteria.setProjection(Projections.sum("price"));
        int sum = Integer.parseInt(criteria.uniqueResult().toString());

        Book book = new Book();
        book.setSumPrice(sum);
        book.setMaxPrice(max);
        book.setMinPrice(min);
        
        session.getTransaction().commit();
        return book;
    }
}