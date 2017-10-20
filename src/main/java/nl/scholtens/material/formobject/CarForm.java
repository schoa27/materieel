package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Car;

import java.util.List;

public class CarForm extends Body {

    private List<Car> cars;

    private Car car;

    public CarForm(String version, String date) {
        super(version, date);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
