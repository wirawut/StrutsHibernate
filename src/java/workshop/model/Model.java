package workshop.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Model{
    public static SessionFactory factory;
    static{
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}