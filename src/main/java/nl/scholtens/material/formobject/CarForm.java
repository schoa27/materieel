package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Car;

import java.io.IOException;
import java.util.List;

public class CarForm extends Body {

    private List<Car> cars;

    private Car car;

    public CarForm() throws IOException {
        super();
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
