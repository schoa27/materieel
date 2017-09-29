package nl.scholtens.material.service;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Operator;
import nl.scholtens.material.mapper.MaterialMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    private static Logger logger = LogManager.getLogger(OperatorServiceImpl.class);

    @Autowired
    private CarService carService;

    private MaterialMapper material = new MaterialMapper();

    @Override
    public List<Operator> getOperatorList(String file) {
        List<Operator> operatorList = null;
        try {
            carService.getCarList(file);
            operatorList = makeCarList(material.getOperatorList(file), carService.getCarList(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return operatorList;
    }

    //TODO uitzoeken stream
    private List<Operator> makeCarList(List<Operator> operators, List<Car> cars) {
        for (Operator operator : operators) {
            String[] carIds = operator.getCarIds().split(",");

            for (String carId : carIds) {
                operator.getCars().add(cars.stream()
                        .filter(c -> carId.equals(c.getId())).findAny().get());
            }
        }
        return operators;
    }
}

