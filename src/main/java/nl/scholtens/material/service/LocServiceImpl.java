package nl.scholtens.material.service;

import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.mapper.MaterialMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class LocServiceImpl implements LocService {

    private static Logger logger = LogManager.getLogger(LocServiceImpl.class);

    private MaterialMapper material = new MaterialMapper();

    @Override
    public List<Locomotive> getLocList(String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);
        for (Locomotive locomotive: locomotives) {
            getSlaveLocomotives(locomotive, locomotives);
        }
        return locomotives;
    }

    @Override
    public Locomotive getLoc(String id, String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);

        return locomotives
                .stream()
                .filter(locomotive -> locomotive.getId().equals(Integer.parseInt(id)))
                .findFirst()
                .get();

    }

    @Override
    public Locomotive getLocById(String locId, String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);

        Locomotive locomotive = getLocomotive(locId, locomotives);
        if (locomotive != null) {
            getSlaveLocomotives(locomotive, locomotives);
        }
        return locomotive;
    }

    private Locomotive getLocomotive(String locId, List<Locomotive> locomotives) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getLocid().equals(locId)) return locomotive;
        }
        logger.error("no loc found for id " + locId);
        return null;
    }

    private Locomotive getSlaveLocomotives(Locomotive locomotive, List<Locomotive> locomotives) {
        String[] locIds = locomotive.getSlaveLocIds().split(",");
        for (String locId : locIds) {
            if (!locId.isEmpty()) locomotive.getSlaveLocList().add(getLocomotive(locId, locomotives));
        }
        return locomotive;
    }

    private List<Locomotive> getlocListFromFile(String file) {
        try {
            return material.getlocList(file);
        } catch (FileNotFoundException e) {
            logger.error("collecting loc list file not found");
            e.printStackTrace();
        } catch (JAXBException e) {
            logger.error("collecting loc list XSD parse failure JAXB");
            e.printStackTrace();
        } catch (SAXException e) {
            logger.error("collecting loc list XSD parse failure SAX");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("collecting loc list IO exception");
            e.printStackTrace();
        }
        logger.error("collecting loc list");
        return null;
    }
}
