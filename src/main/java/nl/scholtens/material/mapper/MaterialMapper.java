package nl.scholtens.material.mapper;

import nl.scholtens.material.domain.Car;
import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.domain.Operator;
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

    private List<Plan.Operatorlist.Operator> operatorList;

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
                operatorList = operatorlistObject.getOperator();
            }
        }
    }

    public List<Locomotive> getlocList(String file) throws FileNotFoundException, JAXBException, SAXException {
        List<Locomotive> locotives = new ArrayList<>();
        getPlanGegevens(file);

        for (Plan.Lclist.Lc loc : locList) {
            locotives.add(getLocomtive(loc));
        }
        return locotives;
    }

    public List<Car> getCarList(String file) throws FileNotFoundException, JAXBException, SAXException {
        List<Car> cars = new ArrayList<>();
        getPlanGegevens(file);

        for (Plan.Carlist.Car car : carList) {
            cars.add(getCar(car));
        }
        return cars;
    }

    public List<Operator> getOperatorList(String file) throws FileNotFoundException, JAXBException, SAXException {
        List<Operator> operators = new ArrayList<>();
        getPlanGegevens(file);

        for (Plan.Operatorlist.Operator operator : operatorList) {
            operators.add(new Operator(operator.getId(), operator.getLcid(), operator.getCarids()));
        }
        return operators;
    }

    private Locomotive getLocomtive(Plan.Lclist.Lc loc) {
        Locomotive locomotive = new Locomotive();
        locomotive.setId(loc.getId());
        locomotive.setNumber(loc.getNumber());
        locomotive.setCompany(loc.getRoadname());
        locomotive.setEra(loc.getEra());
        locomotive.setLength(Integer.parseInt(loc.getLen()));
        locomotive.setTrainType(loc.getCargo());
        locomotive.setOwner(loc.getOwner());
        locomotive.setCatalogNumber(loc.getCatnr());
        locomotive.setEngine(loc.getEngine());
        locomotive.setImage(loc.getImage());
        locomotive.setDecoder(getDecoder(loc, null));
        return locomotive;
    }

    private Car getCar(Plan.Carlist.Car car) {
        Car newCar = new Car();
        newCar.setId(car.getId());
        newCar.setCompany(car.getRoadname());
        newCar.setManufactor(car.getOwner());
        newCar.setType(car.getType());
        newCar.setEra(car.getEra());
        newCar.setImage(car.getImage());

        if (!car.getDectype().isEmpty()) {
            newCar.setDecoder(getDecoder(null, car));
        }

        return newCar;
    }

    private Decoder getDecoder(Plan.Lclist.Lc loc, Plan.Carlist.Car car) {
        Decoder decoder = new Decoder();
        if (loc != null) {
            decoder.setAddress(Integer.parseInt(loc.getAddr()));
            decoder.setFunctionCount(Integer.parseInt(loc.getFncnt()));
            decoder.setManufacture(loc.getDectype());
            decoder.setProtocol(loc.getProt());
            decoder.setSpeedSteps(Integer.parseInt(loc.getSpcnt()));
        }
        if (car != null) {
            decoder.setAddress(Integer.parseInt(car.getAddr()));
            decoder.setFunctionCount(car.getFundef().size());
            decoder.setManufacture(car.getDectype());
            decoder.setProtocol(car.getProt());
            decoder.setSpeedSteps(Integer.parseInt(car.getSpcnt()));
        }
        return decoder;
    }


}
