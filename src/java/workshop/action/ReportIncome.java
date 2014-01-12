package workshop.action;

import java.util.Calendar;
import java.util.List;
import workshop.model.IncomeModel;

public class ReportIncome extends IndexAction {

    private List incomeList;
    private IncomeModel incomeModel;
    private int total;
    private int year;
    private int month;

    public ReportIncome() {
        incomeModel = new IncomeModel();

        Calendar c = Calendar.getInstance();
        year = c.get(c.YEAR);
        month = c.get(c.MONTH);
    }

    public List getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(List incomeList) {
        this.incomeList = incomeList;
    }

    public IncomeModel getIncomeModel() {
        return incomeModel;
    }

    public void setIncomeModel(IncomeModel incomeModel) {
        this.incomeModel = incomeModel;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String execute() {
        incomeList = incomeModel.ReportIncome(year, month);

        for (int i = 0; i < incomeList.size(); i++) {
            IncomeModel model = (IncomeModel) incomeList.get(i);
            total += model.getMoney();
        }
        return "SUCCESS";
    }
}
