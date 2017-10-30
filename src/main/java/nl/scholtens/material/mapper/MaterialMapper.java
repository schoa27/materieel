package nl.scholtens.material.mapper;

import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.enums.constants.*;
import nl.scholtens.material.sources.Car;
import nl.scholtens.material.sources.Lc;
import nl.scholtens.material.sources.Operator;
import nl.scholtens.material.sources.Plan;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper {

    private PlanMapper planMapper = new PlanMapper();

    private Plan getPlanGegevens(String file) throws IOException, JAXBException, SAXException {
        Plan plan = planMapper.mapPlan(file);
        return plan;
    }

    public List<Locomotive> getlocList(String file) throws IOException, JAXBException, SAXException {
        List<Locomotive> locomotives = new ArrayList<>();
        int id = 0;

        for (Lc loc : getPlanGegevens(file).getLclist().getLc()) {
            locomotives.add(getLocomtive(loc, id++));
        }
        return locomotives;
    }

    public List<Waggon> getCarList(String file) throws IOException, JAXBException, SAXException {
        List<Waggon> waggons = new ArrayList<>();
        int id = 0;

        for (Car car : getPlanGegevens(file).getCarlist().getCar()) {
            waggons.add(getCar(car, id++));
        }
        return waggons;
    }

    public List<OperatorTrain> getOperatorList(String file) throws IOException, JAXBException, SAXException {
        List<OperatorTrain> operatorTrains = new ArrayList<>();
        getPlanGegevens(file);

        for (Operator operator : getPlanGegevens(file).getOperatorlist().getOperator()) {
            operatorTrains.add(new OperatorTrain(operator.getId(), operator.getLcid(), operator.getCarids()));
        }
        return operatorTrains;
    }

    private Locomotive getLocomtive(Lc loc, int id) {
        Locomotive locomotive = new Locomotive();
        locomotive.setId(id);
        locomotive.setLocid(loc.getId());
        locomotive.setNumber(loc.getNumber());
        locomotive.setCompany(loc.getRoadname());
        locomotive.setEra(Constanten.EPOCH[loc.getEra().intValue()]);
        locomotive.setLength(Integer.parseInt(loc.getLen().toString()));
        locomotive.setTrainType(TrainType.valueOf(loc.getCargo().toUpperCase()).getTraintype());
        locomotive.setOwner(loc.getOwner());
        locomotive.setCatalogNumber(loc.getCatnr());
        locomotive.setEngine(Engine.valueOf(loc.getEngine().toUpperCase()).getEngine());
        locomotive.setImage(loc.getImage());
        locomotive.setSlaveLocIds(loc.getConsist());
        locomotive.setDecoder(getDecoder(loc, null));
        return locomotive;
    }

    private Waggon getCar(Car car, int id) {
        Waggon waggon = new Waggon();
        waggon.setId(id);
        waggon.setCarid(car.getId());
        waggon.setCompany(car.getRoadname());
        waggon.setManufactor(car.getOwner());
        waggon.setCatalognr(car.getCatnr());
        waggon.setType(CarType.valueOf(car.getType().toUpperCase()).getCartype());
        waggon.setEra(Constanten.EPOCH[car.getEra().intValue()]);
        waggon.setLength(Integer.parseInt(car.getLen().toString()));
        waggon.setImage(car.getImage());
        if (!car.getDectype().isEmpty())  waggon.setDecoder(getDecoder(null, car));
        return waggon;
    }

    private Decoder getDecoder(Lc loc, Car car) {
        Decoder decoder = new Decoder();
        if (loc != null) {
            decoder.setAddress(Integer.parseInt(loc.getAddr().toString()));
            decoder.setFunctionCount(Integer.parseInt(loc.getFncnt().toString()));
            decoder.setManufacture(loc.getDectype());
            decoder.setProtocol(Protocol.valueOf(loc.getProt()).getProtocol());
            decoder.setSpeedSteps(Integer.parseInt(loc.getSpcnt().toString()));
        }
        if (car != null) {
            decoder.setAddress(Integer.parseInt(car.getAddr().toString()));
            decoder.setFunctionCount(car.getFundef().size());
            decoder.setManufacture(car.getDectype());
            if (car.getProt() != null) decoder.setProtocol(Protocol.valueOf(car.getProt()).getProtocol());
            decoder.setSpeedSteps(Integer.parseInt(car.getSpcnt().toString()));
        }
        return decoder;
    }
}
