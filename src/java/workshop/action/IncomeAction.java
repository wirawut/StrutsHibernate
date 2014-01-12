package workshop.action;

import java.util.Date;
import java.util.List;
import workshop.model.IncomeModel;

public class IncomeAction extends IndexAction {

    private int id;
    private IncomeModel incomeModel;
    private List incomeList;

    public IncomeAction() {
        incomeModel = new IncomeModel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IncomeModel getIncomeModel() {
        return incomeModel;
    }

    public void setIncomeModel(IncomeModel incomeModel) {
        this.incomeModel = incomeModel;
    }

    public List getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(List incomeList) {
        this.incomeList = incomeList;
    }

    public String index() {
        incomeList = incomeModel.list();
        return "SUCCESS";
    }

    public String save() {
        if (id == 0) {
            Date createdDate = new Date();
            incomeModel.setIncome_date(createdDate);
            incomeModel.save(incomeModel);
        } else {
            IncomeModel oldIncomeModel = incomeModel.find(id);
            incomeModel.setId(id);
            incomeModel.setIncome_date(oldIncomeModel.getIncome_date());
            incomeModel.update(incomeModel);
        }
        return "SUCCESS";
    }

    public String edit() {
        incomeModel = incomeModel.find(id);
        incomeList = incomeModel.list();
        return "SUCCESS";
    }

    public String delete() {
        incomeModel.delete(id);
        return "SUCCESS";
    }
}
