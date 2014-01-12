package workshop.model;

import java.util.List;
import org.hibernate.Session;

public class VegetableModel extends Model {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List list() {
        Session session = factory.openSession();
        session.beginTransaction();
        List vegetables = session.createQuery("From VegetableModel").list();
        session.getTransaction().commit();
        session.close();
        return vegetables;
    }

    public void save(VegetableModel vegetableModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(vegetableModel);
        session.getTransaction().commit();
        session.close();
    }

    public VegetableModel find(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        VegetableModel vegetable = (VegetableModel) session.get(VegetableModel.class, id);
        session.getTransaction().commit();
        session.close();
        return vegetable;
    }

    public void update(VegetableModel vegetableModel, int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        vegetableModel.setId(id);
        session.update(vegetableModel);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        VegetableModel vegetable = (VegetableModel) session.get(VegetableModel.class, id);
        session.delete(vegetable);
        session.getTransaction().commit();
        session.close();
    }
}