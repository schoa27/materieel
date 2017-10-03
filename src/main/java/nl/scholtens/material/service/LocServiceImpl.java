package nl.scholtens.material.service;

import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.mapper.MaterialMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class LocServiceImpl implements LocService {

    private static Logger logger = LogManager.getLogger(LocServiceImpl.class);

    private MaterialMapper material = new MaterialMapper();

    @Override
    public List<Locomotive> getLocList(String file) {
        return getlocListFromFile(file);
    }

    @Override
    public Locomotive getLocById(String locId, String file) {
        List<Locomotive> locomotives = getlocListFromFile(file);
        return locomotives.get(Integer.parseInt(locId));
    }

    private List<Locomotive> getlocListFromFile(String file) {
        try {
            return material.getlocList(file);
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
