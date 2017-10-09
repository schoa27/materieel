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
import java.io.IOException;
import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    private static Logger logger = LogManager.getLogger(OperatorServiceImpl.class);

    @Autowired
    private CarService carService;

    @Autowired
    private LocService locService;

    private MaterialMapper material = new MaterialMapper();

    @Override
    public List<Operator> getOperatorList(String file) {
        List<Operator> operators = makeCarList(getOperatorsFromFile(file), carService.getCarList(file));
        return operators;
    }

    @Override
    public Operator getOperatorById(String operatorId, String file) {
        List<Operator> operators = getOperatorList(file);
        return getLocById(operators.get(Integer.parseInt(operatorId)), file);
    }

    private List<Operator> makeCarList(List<Operator> operators, List<Car> cars) {
        for (Operator operator : operators) {
            String[] carIds = operator.getCarIds().split(",");

            for (String carId : carIds) {
                for (Car car : cars) {
                    if (car.getId().equals(carId)) {
                        operator.getCars().add(car);
                        if (car.getLength() != null) {
                            operator.setLength(operator.getLength() + car.getLength());
                        }
                    }
                }
            }
        }
        return operators;
    }

    private Operator getLocById(Operator operator, String file) {
        operator.setLocomotive(locService.getLocById(operator.getLocId(), file));

        if (operator.getLocomotive() != null && operator.getLocomotive().getLength() != null) {
            operator.setLength(operator.getLength() + operator.getLocomotive().getLength());
        }
        return operator;
    }

    private List<Operator> getOperatorsFromFile(String file) {
        try {
            return material.getOperatorList(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

