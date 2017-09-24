package nl.scholtens.materieel.service;

import nl.scholtens.materieel.domein.Locomtive;
import nl.scholtens.materieel.mapper.MatrieelMapper;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class LocServiceImpl implements LocService {

    private MatrieelMapper material = new MatrieelMapper();

    @Override
    public List<Locomtive> getLocList(String file) {
        List<Locomtive> locomtives = null;
        try {
            locomtives = material.getlocList(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return locomtives;
    }
}
