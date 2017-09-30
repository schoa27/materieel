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

    @RequestMapping(value = "/{item}", method = RequestMethod.GET)
    public ModelAndView carDetails(@PathVariable(value = "item") String item, ModelAndView model) throws IOException {

        if (item.substring(0, 3).equals("loc")) {
            LocForm form = new LocForm();
            form.setLocomotive(locService.getLocById(item.substring(4), getXmlPath()));
            model.addObject("form", form);
            model.setViewName("locDetails");
        }

        if (item.substring(0, 3).equals("car")) {
            CarForm form = new CarForm();
            form.setCar(carService.getCarById(item.substring(4), getXmlPath()));
            model.addObject("form", form);
            model.setViewName("carDetails");
        }

        if (item.substring(0, 3).equals("opr")) {

        }

        return model;
    }

    private String getImagePath() {
        final String[] paths = readSetupFile();
        return paths[1];
    }

    private String getXmlPath() {
        final String[] paths = readSetupFile();
        return paths[0];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }
}
