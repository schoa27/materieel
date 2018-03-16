package nl.scholtens.material.domain;

import java.util.ArrayList;
import java.util.List;

public class OperatorTrain {

    private String id;

    private String locId;

    private Locomotive masterloc = new Locomotive();

    private Locomotive slaveloc = new Locomotive();

    private String carIds;

    private List<Waggon> waggons = new ArrayList<>();

    private Integer length = 0;

    public OperatorTrain() {
        super();
    }

    public OperatorTrain(String id, String locId, String carIds) {
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

    public Locomotive getMasterloc() {
        return masterloc;
    }

    public void setMasterloc(Locomotive masterloc) {
        this.masterloc = masterloc;
    }

    public Locomotive getSlaveloc() {
        return slaveloc;
    }

    public void setSlaveloc(Locomotive slaveloc) {
        this.slaveloc = slaveloc;
    }

    public String getCarIds() {
        return carIds;
    }

    public void setCarIds(String carIds) {
        this.carIds = carIds;
    }

    public List<Waggon> getWaggons() {
        return waggons;
    }

    public void setWaggons(List<Waggon> waggons) {
        this.waggons = waggons;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
