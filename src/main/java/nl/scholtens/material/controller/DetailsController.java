package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.CarForm;
import nl.scholtens.material.formobject.LocForm;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import nl.scholtens.material.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class DetailsController {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Autowired
    private SetupService setupService;

    @RequestMapping(value = "/detail/loc/{loc}", method = RequestMethod.GET)
    public ModelAndView locDetails(@PathVariable(value = "loc") String locId, ModelAndView model) throws IOException {
        LocForm form = new LocForm();
        form.setLocomotive(locService.getLocById(locId, getXmlPath()));

        model.addObject("form", form);
        model.setViewName("locDetails");
        return model;
    }

    @RequestMapping(value = "/detail/car/{car}", method = RequestMethod.GET)
    public ModelAndView carDetails(@PathVariable(value = "car") String carId, ModelAndView model) throws IOException {
        CarForm form = new CarForm();
        form.setCar(carService.getCarById(carId, getXmlPath()));
        model.addObject("form", form);
        model.setViewName("carDetails");
        return model;
    }

    @RequestMapping(value = "/detail/operator/{operator}", method = RequestMethod.GET)
    public ModelAndView operatorDetails(@PathVariable(value = "operator") String operatorId, ModelAndView model) {


        model.setViewName("operatorDetails");
        return model;
    }

    private String getImagePath( ) {
        final String[] paths = readSetupFile();
        return paths[1];
    }

    private String getXmlPath( ) {
        final String[] paths = readSetupFile();
        return paths[0];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }
}
