package nl.scholtens.material.service;

import nl.scholtens.material.domain.Waggon;

import java.util.List;

public interface CarService {

    public List<Waggon> getCarList(String file);

    Waggon getCarById(String carId, String file);
}
