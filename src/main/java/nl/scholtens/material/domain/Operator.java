package nl.scholtens.material.domain;

import java.util.ArrayList;
import java.util.List;

public class Operator {

    private String id;

    private String locId;

    private Locomtive locomtive = new Locomtive();

    private String carIds;

    private List<Car> cars = new ArrayList<>();

    public Operator() {
        super();
    }

    public Operator(String id, String locId, String carIds) {
        this.id = id;
        this.locId = locId;
        this.carIds = carIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public Locomtive getLocomtive() {
        return locomtive;
    }

    public void setLocomtive(Locomtive locomtive) {
        this.locomtive = locomtive;
    }

    public String getCarIds() {
        return carIds;
    }

    public void setCarIds(String carIds) {
        this.carIds = carIds;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
