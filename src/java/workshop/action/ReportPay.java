package workshop.action;

import java.util.Calendar;
import java.util.List;
import workshop.model.PayModel;

public class ReportPay extends IndexAction{

    private List payList;
    private PayModel payModel;
    private int total;
    private int year;
    private int month;

    public ReportPay() {
        payModel = new PayModel();

        Calendar c = Calendar.getInstance();
        year = c.get(c.YEAR);
        month = c.get(c.MONTH);
    }

    public List getPayList() {
        return payList;
    }

    public void setPayList(List payList) {
        this.payList = payList;
    }

    public PayModel getPayModel() {
        return payModel;
    }

    public void setPayModel(PayModel payModel) {
        this.payModel = payModel;
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
        payList = payModel.ReportPay(year, month);
        for (int i = 0; i < payList.size(); i++) {
            PayModel model = (PayModel) payList.get(i);
            total += model.getMoney();
        }
        return "SUCCESS";

    }
}
