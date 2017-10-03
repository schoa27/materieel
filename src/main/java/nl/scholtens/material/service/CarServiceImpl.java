package nl.scholtens.material.service;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.mapper.MaterialMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static Logger logger = LogManager.getLogger(CarServiceImpl.class);

    private MaterialMapper material = new MaterialMapper();

    private List<Car> cars;

    @Override
    public List<Car> getCarList(String file) {
        return getCarsFromFile(file);
    }

    @Override
    public Car getCarById(String carId, String file) {
        List<Car> cars = getCarList(file);
        return cars.get(Integer.parseInt(carId));
    }

    private List<Car> getCarsFromFile(String file) {
        try {
            return material.getCarList(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
