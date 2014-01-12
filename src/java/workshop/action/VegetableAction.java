package workshop.action;

import java.util.List;
import workshop.model.VegetableModel;

public class VegetableAction extends IndexAction {

    private int id;
    private List vegetableList;
    private VegetableModel vegetableModel;
    
    //constructor
    public VegetableAction(){
        vegetableModel = new VegetableModel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getVegetableList() {
        return vegetableList;
    }

    public void setVegetableList(List vegetableList) {
        this.vegetableList = vegetableList;
    }

    public VegetableModel getVegetableModel() {
        return vegetableModel;
    }

    public void setVegetableModel(VegetableModel vegetableModel) {
        this.vegetableModel = vegetableModel;
    }

    public String index() {
        vegetableList = vegetableModel.list();
        return "SUCCESS";
    }

    public String save() {
        if (id == 0) {
            vegetableModel.save(vegetableModel);
        } else {
            vegetableModel.update(vegetableModel, id);
            setId(0);
        }
        vegetableList = vegetableModel.list();
        return "SUCCESS";
    }

    public String edit() {
        vegetableModel = vegetableModel.find(id);
        vegetableList = vegetableModel.list();
        return "SUCCESS";
    }

    public String delete() {
        vegetableModel.delete(id);
        vegetableList = vegetableModel.list();
        return "SUCCESS";
    }
}