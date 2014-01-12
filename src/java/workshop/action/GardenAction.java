package workshop.action;

import java.util.List;
import workshop.model.GardenModel;

public class GardenAction  extends IndexAction{

    private GardenModel gardenModel;
    private List gardenList;
    private int id;

    public GardenAction() {
        gardenModel = new GardenModel();
    }

    public GardenModel getGardenModel() {
        return gardenModel;
    }

    public void setGardenModel(GardenModel gardenModel) {
        this.gardenModel = gardenModel;
    }

    public List getGardenList() {
        return gardenList;
    }

    public void setGardenList(List gardenList) {
        this.gardenList = gardenList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //เริ่มต้นสร้างเมธอดเพิ่ม ลบ เเก้ไข เเสดง
    public String index() {
        gardenList = gardenModel.list();
        return "SUCCESS";
    }

    public String save() {
        if (id == 0) {
            gardenModel.save(gardenModel);
        } else {
            gardenModel.update(gardenModel, id);
            setId(0);
        }
        gardenList = gardenModel.list();
        return "SUCCESS";
    }

    public String edit() {
        gardenModel = gardenModel.find(id);
        gardenList = gardenModel.list();
        return "SUCCESS";
    }

    public String delete() {
        gardenModel.delete(id);
        gardenList = gardenModel.list();
        return "SUCCESS";
    }
}
