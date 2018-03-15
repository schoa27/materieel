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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LocServiceImpl implements LocService {

    private static Logger logger = LogManager.getLogger(LocServiceImpl.class);

    private MaterialMapper material = new MaterialMapper();

    @Override
    public List<Locomotive> getLocList(String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);
        if (locomotives != null) {
            locomotives.stream()
                       .forEach(locomotive -> getSlaveLocomotives(locomotive, locomotives));
        }
        return locomotives;
    }

    @Override
    public Locomotive getLocById(String id, String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);
        return getSlaveLocomotives(getLocomotiveById(id, locomotives), locomotives);
    }

    @Override
    public Locomotive getSlaveLocs(String id, String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);

        Locomotive locomotive = getLocomotiveById(id, locomotives);
        Locomotive masterloc = getMasterLoc(locomotive, locomotives);

        if (masterloc == null) {
            getSlaveLocomotives(locomotive, locomotives);
        } else {
            locomotive = masterloc;
            locomotive.setSlaveLocList(getSlaveLocomotives(masterloc, locomotives).getSlaveLocList());
        }
        return locomotive;
    }

    @Override
    public Locomotive getLocByLocId(String locId, String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);

        Locomotive locomotive = getLocomotiveByLocId(locId, locomotives);
        if (locomotive != null && locomotive.getSlaveLocIds().isEmpty()) {
            getSlaveLocomotives(locomotive, locomotives);
        }
        return locomotive;
    }

    @Override
    public Locomotive getMasterLoc(Locomotive loc, List<Locomotive> locomotives) {
        Optional<Locomotive> masterLoc = locomotives
                .stream()
                .filter(l -> l.getSlaveLocIds().contains(loc.getLocid())).findFirst();

        return masterLoc.isPresent()? masterLoc.get():null;
    }

    private Locomotive getLocomotiveById(String id, List<Locomotive> locomotives) {
        return locomotives
                .stream()
                .filter(loc -> loc.getId().equals(Integer.parseInt(id)))
                .findFirst()
                .get();
    }

    private Locomotive getLocomotiveByLocId(String locId, List<Locomotive> locomotives) {
        return locomotives
                .stream()
                .filter(locomotive -> locomotive != null)
                .filter(locomotive -> locomotive.getLocid() != null)
                .filter(locomotive -> locomotive.getLocid().equals(locId))
                .findFirst()
                .get();
    }

    private Locomotive getSlaveLocomotives(Locomotive locomotive, List<Locomotive> locomotives) {
        String[] locIds = locomotive.getSlaveLocIds().split(",");

        Arrays.stream(locIds)
              .filter(locId -> !locId.isEmpty())
              .forEach(locId -> locomotive.getSlaveLocList().add(getLocomotiveByLocId(locId, locomotives)));
        
        return locomotive;
    }

    private List<Locomotive> getlocListFromFile(String file) {
        try {
            return material.getLocList(file);
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
