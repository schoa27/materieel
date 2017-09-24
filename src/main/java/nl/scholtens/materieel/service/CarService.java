package nl.scholtens.materieel.service;

import nl.scholtens.materieel.domein.Car;

import java.util.List;

public interface CarService {

    public List<Car> getCarList(String file);
}
