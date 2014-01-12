package workshop.model;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PayModel extends Model {

    private int id;
    private String name;
    private int money;
    private Date created_date;

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public List list() {
        Session session = factory.openSession();
        session.beginTransaction();

        List list = session.createQuery("FROM PayModel").list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void save(PayModel payModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(payModel);
        session.getTransaction().commit();
        session.close();
    }

    public void update(PayModel payModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(payModel);
        session.getTransaction().commit();
        session.close();
    }

    public PayModel find(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        PayModel payModel = (PayModel) session.get(PayModel.class, id);
        session.getTransaction().commit();
        session.close();
        return payModel;
    }

    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        PayModel payModel = (PayModel) session.get(PayModel.class, id);
        session.delete(payModel);
        session.getTransaction().commit();
        session.close();
    }

    public List ReportPay(int year, int month) {
        Session session = factory.openSession();
        session.beginTransaction();

        String hql = ""
                + " FROM PayModel"
                + " WHERE"
                + " YEAR(created_date) = :year"
                + " AND MONTH(created_date) = :month";

        Query query = session.createQuery(hql);
        query.setParameter("year", year);
        query.setParameter("month", month);

        List list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }
}
