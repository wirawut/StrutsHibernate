package workshop.model;

import java.util.List;
import org.hibernate.Session;

public class GardenModel extends Model {

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

        List gardens = session.createQuery("FROM GardenModel ORDER BY name ASC").list();
        session.getTransaction().commit();
        session.close();
        return gardens;
    }

    public void save(GardenModel gardenModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(gardenModel);
        session.getTransaction().commit();
        session.close();
    }

    public GardenModel find(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        GardenModel garden = (GardenModel) session.get(GardenModel.class, id);
        session.getTransaction().commit();
        session.close();
        return garden;
    }

    public void update(GardenModel gardenModel, int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        gardenModel.setId(id);

        session.update(gardenModel);
        session.getTransaction().commit();
        session.close();

    }

    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        GardenModel garden = (GardenModel) session.get(GardenModel.class, id);
        session.delete(garden);

        session.getTransaction().commit();
        session.close();
    }

   
}