package nl.scholtens.material.service;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.mapper.MaterialMapper;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private MaterialMapper material = new MaterialMapper();

    private List<Car> cars;

    @Override
    public List<Car> getCarList(String file) {

        try {
            cars = material.getCarList(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car getCarById(String carId, List<Car> cars) {
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
}
