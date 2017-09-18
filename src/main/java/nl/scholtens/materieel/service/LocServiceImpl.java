package nl.scholtens.materieel.service;

import nl.scholtens.materieel.domein.Locomtief;
import nl.scholtens.materieel.mapper.MatrieelMapper;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocServiceImpl implements LocService {

    private MatrieelMapper materieel = new MatrieelMapper();

    @Override
    public List<Locomtief> ophalenLocLijst() {
        List<Locomtief> locomtiefs = null;
        try {
            locomtiefs = materieel.getlocList("/data/Data/rocrail/loc.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return locomtiefs;
    }
}
