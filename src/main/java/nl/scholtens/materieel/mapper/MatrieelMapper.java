package nl.scholtens.materieel.mapper;

import nl.scholtens.materieel.domein.Locomtief;
import nl.scholtens.materieel.sources.Plan;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MatrieelMapper {

    private PlanMapper planMapper = new PlanMapper();

    private List<Plan.Lclist.Lc> locLijst;

    private List<Plan.Carlist.Car> wagenlijst;

    private List<Plan.Operatorlist.Operator> stamlijst;

    private void getPlanGegevens(String file) throws FileNotFoundException, JAXBException, SAXException {
        Plan plan = planMapper.mapPlan(file);

        List<Object> objectenLijst = plan.getFundefOrLclistOrCarlist();

        for (Object object : objectenLijst) {
            if (object instanceof Plan.Lclist) {
                Plan.Lclist LclistObject = (Plan.Lclist) object;
                locLijst = LclistObject.getLc();
            }
            if (object instanceof Plan.Carlist) {
                Plan.Carlist carlistObject = (Plan.Carlist) object;
                wagenlijst = carlistObject.getCar();
            }
            if (object instanceof Plan.Operatorlist) {
                Plan.Operatorlist operatorlistObject = (Plan.Operatorlist) object;
                stamlijst = operatorlistObject.getOperator();
            }
        }
    }

    public List<Locomtief> getlocList(String file) throws FileNotFoundException, JAXBException, SAXException {
        List<Locomtief> locotieven = new ArrayList<>();
        getPlanGegevens(file);

        for (Plan.Lclist.Lc loc : locLijst) {
            locotieven.add(new Locomtief(loc.getId(), loc.getNumber(), loc.getEngine()));
        }

        return locotieven;

    }
}
