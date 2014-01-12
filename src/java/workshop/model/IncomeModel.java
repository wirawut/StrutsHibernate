package workshop.model;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class IncomeModel extends Model {

    private int id;
    private Date income_date;
    private String name;
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIncome_date() {
        return income_date;
    }

    public void setIncome_date(Date income_date) {
        this.income_date = income_date;
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

    public List list() {
        Session session = factory.openSession();
        session.beginTransaction();

        List incomeList = session.createQuery("FROM IncomeModel").list();
        session.getTransaction().commit();
        session.close();
        return incomeList;

    }

    public void save(IncomeModel incomeModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(incomeModel);
        session.getTransaction().commit();
        session.close();
    }

    public void update(IncomeModel incomeModel) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(incomeModel);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        IncomeModel incomeModel = (IncomeModel) session.get(IncomeModel.class, id);
        session.delete(incomeModel);
        session.getTransaction().commit();
        session.close();
    }

    public IncomeModel find(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        IncomeModel income = (IncomeModel) session.get(IncomeModel.class, id);
        session.getTransaction().commit();
        session.close();
        return income;

    }

    //report income list
    public List ReportIncome(int year, int month) {
        Session session = factory.openSession();
        session.beginTransaction();

        String hql = ""
                + " FROM IncomeModel"
                + " WHERE"
                + " YEAR(income_date) = :year "
                + " AND MONTH(income_date) = :month";
        Query query = session.createQuery(hql);
        query.setParameter("year", year);
        query.setParameter("month", month);

        List list = query.list();
        session.getTransaction().commit();
        session.close();

        return list;
    }
}
