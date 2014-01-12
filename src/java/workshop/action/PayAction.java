package workshop.action;

import java.util.Date;
import java.util.List;
import workshop.model.PayModel;

public class PayAction extends IndexAction {

    private int id;
    private PayModel payModel;
    private List payList;

    public PayAction(){
       payModel = new PayModel();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PayModel getPayModel() {
        return payModel;
    }

    public void setPayModel(PayModel payModel) {
        this.payModel = payModel;
    }

    public List getPayList() {
        return payList;
    }

    public void setPayList(List payList) {
        this.payList = payList;
    }

    public String index() {
        payList = payModel.list();
        return "SUCCESS";
    }

    public String save() {
        if (id == 0) {
            Date createdDate = new Date();
            payModel.setCreated_date(createdDate);
            payModel.save(payModel);
        } else {
            PayModel oldPaymodel = payModel.find(id);
            payModel.setId(id);
            payModel.setCreated_date(oldPaymodel.getCreated_date());
            payModel.update(payModel);
        }
        return "SUCCESS";
    }

    public String edit() {
        payModel = payModel.find(id);
        payList = payModel.list();
        return "SUCCESS";
    }

    public String delete() {
        payModel.delete(id);
        return "SUCCESS";
    }
}
