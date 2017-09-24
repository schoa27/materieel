package nl.scholtens.material.mapper;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Locomtive;
import nl.scholtens.material.sources.Plan;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {

    private PlanMapper planMapper = new PlanMapper();

    private List<Plan.Lclist.Lc> locList;

    private List<Plan.Carlist.Car> carList;

    private List<Plan.Operatorlist.Operator> stamlijst;

    private void getPlanGegevens(String file) throws FileNotFoundException, JAXBException, SAXException {
        Plan plan = planMapper.mapPlan(file);

        List<Object> objectenLijst = plan.getFundefOrLclistOrCarlist();

        for (Object object : objectenLijst) {
            if (object instanceof Plan.Lclist) {
                Plan.Lclist LclistObject = (Plan.Lclist) object;
                locList = LclistObject.getLc();
            }
            if (object instanceof Plan.Carlist) {
                Plan.Carlist carlistObject = (Plan.Carlist) object;
                carList = carlistObject.getCar();
            }
            if (object instanceof Plan.Operatorlist) {
                Plan.Operatorlist operatorlistObject = (Plan.Operatorlist) object;
                stamlijst = operatorlistObject.getOperator();
            }
        }
    }

    public List<Locomtive> getlocList(String file) throws FileNotFoundException, JAXBException, SAXException {
        List<Locomtive> locotives = new ArrayList<>();
        getPlanGegevens(file);

        for (Plan.Lclist.Lc loc : locList) {
            Locomtive locomtive = new Locomtive(loc.getId(), loc.getNumber(), loc.getEngine());
            locomtive.setDecoderAdres(loc.getAddr());
            locomtive.setTypeNummer(loc.getCatnr());
            locomtive.setAfbeelding(loc.getImage());
            locotives.add(locomtive);
        }
        return locotives;
    }

    public List<Car> getCarList(String file) throws FileNotFoundException, JAXBException, SAXException {
        List<Car> cars = new ArrayList<>();
        getPlanGegevens(file);

        for (Plan.Carlist.Car car : carList) {
            Car newCar = new Car(car.getId(), car.getRoadname(), car.getType(), car.getDectype().isEmpty());
            newCar.setImage(car.getImage());
            cars.add(newCar);
        }

        return cars;
    }


}
