package workshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import workshop.model.CreateModel;
import workshop.model.GardenModel;
import workshop.model.VegetableModel;

public class CreateAction extends IndexAction {

    private int id;
    private List createList;
//เอาไว้เรียกใช้จากคลาส ต่างๆ
    private CreateModel createModel;
    private GardenModel gardenModel;
    private VegetableModel vegetableModel;
//เก็บข้อมูลเป็นอาเรย์เพื่อเก็บข้อมูลคลาสอื่นๆ
    private List gardenList;
    private List vegetableList;

    public CreateAction() {
//Model
        createModel = new CreateModel();
        gardenModel = new GardenModel();
        vegetableModel = new VegetableModel();

        //List
        vegetableList = new ArrayList();
        gardenList = new ArrayList();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getCreateList() {
        return createList;
    }

    public void setCreateList(List createList) {
        this.createList = createList;
    }

    public CreateModel getCreateModel() {
        return createModel;
    }

    public void setCreateModel(CreateModel createModel) {
        this.createModel = createModel;
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

    public List getGardenList() {
        return gardenList;
    }

    public void setGardenList(List gardenList) {
        this.gardenList = gardenList;
    }

    public List getVegetableList() {
        return vegetableList;
    }

    public void setVegetableList(List vegetableList) {
        this.vegetableList = vegetableList;
    }
    //หลังจากสร้างget set ข้างบนเเล้วก็จะ สร้างactionเพื่อเรียกใช้ Model

    public String index() {
        createList = createModel.list();
        return "SUCCESS";
    }

    public String form() {
        List vegetable = vegetableModel.list();
        List garden = gardenModel.list();

        for (int i = 0; i < vegetable.size(); i++) {
            vegetableList.add(vegetable.get(i));
        }
        for (int i = 0; i < garden.size(); i++) {
            gardenList.add(garden.get(i));
        }
        return "SUCCESS";
    }

    public String save() {
        if (id == 0) {
            //New Record

            //สำหรับลงในfieldวันที่
            Date createdDate = new Date();
 Date getDate = new Date();
            //setทั้ง5field
            createModel.setGardenModel(gardenModel);
            createModel.setVegetableModel(vegetableModel);
            createModel.setCreated_date(createdDate);
            createModel.setStatus("use");
            createModel.setGet_date(getDate);
            createModel.save(createModel);

        } else {
            //Update Record
            createModel = createModel.find(id);
            createModel.setGardenModel(gardenModel);
            createModel.setVegetableModel(vegetableModel);
            createModel.update(createModel);
            createModel.setId(0);
        }
        createList = createModel.list();
        return "SUCCESS";
    }

    public String edit() {
        createModel = createModel.find(getId());

        vegetableList = createModel.getVegetableModel().list();
        gardenList = createModel.getGardenModel().list();

        vegetableModel.setId(createModel.getVegetableModel().getId());
        gardenModel.setId(createModel.getGardenModel().getId());
        return "SUCCESS";
    }

    public String keep() {
        createModel.keep(id);
        return "SUCCESS";
    }

    public String delete() {
        createModel.delete(id);
        return "SUCCESS";
    }
}