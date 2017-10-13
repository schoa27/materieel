package nl.scholtens.material.domain;

import java.util.ArrayList;
import java.util.List;

public class Locomotive {
    private String id;

    private String number;

    private String company;

    private String owner;

    private String catalogNumber;

    private String engine;

    private String era;

    private String trainType;

    private Integer length;

    private String image;

    private Decoder decoder = new Decoder();

    private String slaveLocIds;

    private List<Locomotive> slaveLocList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Decoder getDecoder() {
        return decoder;
    }

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public String getSlaveLocIds() {
        return slaveLocIds;
    }

    public void setSlaveLocIds(String slaveLocIds) {
        this.slaveLocIds = slaveLocIds;
    }

    public List<Locomotive> getSlaveLocList() {
        return slaveLocList;
    }

    public void setSlaveLocList(List<Locomotive> slaveLocList) {
        this.slaveLocList = slaveLocList;
    }
}
