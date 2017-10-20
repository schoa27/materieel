package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Locomotive;

import java.util.ArrayList;
import java.util.List;

public class ResultForm extends Body {

    private List<Locomotive> locomotives = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    public ResultForm(String version, String date) {
        super(version, date);
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
