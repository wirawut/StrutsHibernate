package workshop.model;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import static workshop.model.Model.factory;

public class CreateModel extends Model {

    private int id;
    private GardenModel gardenModel;
    private VegetableModel vegetableModel;
   private Date created_date;
    private String status;
    private Date get_date;
private Date create_date;

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGet_date() {
        return get_date;
    }

    public void setGet_date(Date get_date) {
        this.get_date = get_date;
    }

    public GardenModel getGardenModel() {
        return gardenModel;
    }

    public void setGardenModel(GardenModel gardenModel) {
        this.gardenModel = gardenModel;
    }

    public VegetableModel getVegetableModel() {
        return vegetableModel;
    }

    public void setVegetableModel(VegetableModel vegetableModel) {
        this.vegetableModel = vegetableModel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void save(CreateModel createModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(createModel);
        session.getTransaction().commit();
        session.close();
    }
    public List list() {
        Session session = factory.openSession();
        session.beginTransaction();
        //ดึงmodel มาจากคลาส CreateModel จากตัวเเปล model
        String hql = "SELECT model FROM CreateModel model";
        List createModels = session.createQuery(hql).list();
        session.getTransaction().commit();
        session.close();
        return createModels;
    }

    public CreateModel find(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        CreateModel create = (CreateModel) session.get(CreateModel.class, id);

        session.getTransaction().commit();
        session.close();
        return create;
    }

    public void update(CreateModel createModel) {
        Session session = factory.openSession();
        session.beginTransaction();

        session.update(createModel);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        CreateModel create = (CreateModel) session.get(CreateModel.class, id);
        session.delete(create);
        session.getTransaction().commit();
        session.close();
    }

    public void keep(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        CreateModel create = (CreateModel) session.get(CreateModel.class, id);
        create.setStatus("get");
        create.setGet_date(new Date());
        session.update(create);
        session.getTransaction().commit();
        session.close();
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}