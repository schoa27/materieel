package nl.scholtens.materieel.service;

import nl.scholtens.materieel.domein.Car;
import nl.scholtens.materieel.mapper.MatrieelMapper;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private MatrieelMapper material = new MatrieelMapper();

    @Override
    public List<Car> getCarList(String file) {
        List<Car> cars = null;
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
}
