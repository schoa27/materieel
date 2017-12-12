package nl.scholtens.material.service;

import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.domain.Locomotive;
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
import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorService {

    private static Logger logger = LogManager.getLogger(OperatorServiceImpl.class);

    @Autowired
    private CarService carService;

    @Autowired
    private LocService locService;

    private MaterialMapper material = new MaterialMapper();

    @Override
    public List<OperatorTrain> getOperatorList(String file) {
        List<OperatorTrain> operatorTrains = getOperatorsFromFile(file);
        if (operatorTrains != null) {
            makeCarList(operatorTrains, carService.getCarList(file));
            getLocomotive(operatorTrains, file);
        }
        return operatorTrains;
    }

    @Override
    public OperatorTrain getOperatorById(String operatorId, String file) {
        List<OperatorTrain> operatorTrains = getOperatorList(file);
        OperatorTrain operatorTrain = operatorTrains.get(Integer.parseInt(operatorId));
        getLocById(operatorTrain, file);
        return operatorTrain;
    }

    @Override
    public OperatorTrain getOpertorByLocId(String locId, String file) {
        Locomotive locomotive = locService.getLocById(locId, file);
        List<OperatorTrain> operatorTrains = getOperatorList(file);
        OperatorTrain operatorTrain = getLocomotiveByLocId(operatorTrains, locomotive.getLocid());
        return operatorTrain;
    }

    private List<OperatorTrain> getLocomotive(List<OperatorTrain> operatorTrains, String file) {
        List<Locomotive> locomotives = locService.getLocList(file);

        for (OperatorTrain operatorTrain : operatorTrains) {
            for (Locomotive locomotive : locomotives) {
                if (operatorTrain.getLocId().equals(locomotive.getLocid())) {
                    operatorTrain.setLocomotive(locomotive);
                }
            }
        }
        return operatorTrains;
    }

    private void makeCarList(List<OperatorTrain> operatorTrains, List<Waggon> waggons) {
        for (OperatorTrain operatorTrain : operatorTrains) {
            String[] carIds = operatorTrain.getCarIds().split(",");

            for (String carId : carIds) {
                for (Waggon waggon : waggons) {
                    if (waggon.getCarid().equals(carId)) {
                        operatorTrain.getWaggons().add(waggon);
                        if (waggon.getLength() != null) {
                            operatorTrain.setLength(operatorTrain.getLength() + waggon.getLength());
                        }
                    }
                }
            }
        }
    }

    private void getLocById(OperatorTrain operatorTrain, String file) {
        if (!operatorTrain.getLocId().isEmpty()) {
            operatorTrain.setLocomotive(locService.getLocByLocId(operatorTrain.getLocId(), file));
        }

        if (operatorTrain.getLocomotive() != null && operatorTrain.getLocomotive().getLength() != null) {
            operatorTrain.setLength(operatorTrain.getLength() + operatorTrain.getLocomotive().getLength() + getSlaveLenght(operatorTrain.getLocomotive()));
        }
    }

    private OperatorTrain getLocomotiveByLocId(List<OperatorTrain> operatorTrains, String locId) {
        Optional<OperatorTrain> operatorTrain = operatorTrains
                .stream()
                .filter(o -> o.getLocId() != null)
                .filter(o -> o.getLocId().equals(locId))
                .findFirst();


        if (operatorTrain.isPresent()) {
            return operatorTrain.get();
        }
        return null;
    }

    private Integer getSlaveLenght(Locomotive locomotive) {
        int length = 0;
        if (!locomotive.getSlaveLocList().isEmpty()) {
            for (Locomotive slaveLoc : locomotive.getSlaveLocList()) {
                length = length + slaveLoc.getLength();
            }
        }
        return length;
    }

    private List<OperatorTrain> getOperatorsFromFile(String file) {
        try {
            return material.getOperatorList(file);
        } catch (FileNotFoundException e) {
            logger.error("collecting operator list file not found");
            e.printStackTrace();
        } catch (JAXBException e) {
            logger.error("collecting operator list XSD parse failure JAXB");
            e.printStackTrace();
        } catch (SAXException e) {
            logger.error("collecting operator list XSD parse failure JAXB");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("collecting operator list IO exception");
            e.printStackTrace();
        }
        logger.error("collecting operator list");
        return null;
    }
}

