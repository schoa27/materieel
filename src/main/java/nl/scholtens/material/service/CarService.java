package nl.scholtens.material.service;

import nl.scholtens.material.domain.Car;

import java.util.List;

public interface CarService {

    public List<Car> getCarList(String file);

    Car getCarById(String carId, String file);
}
