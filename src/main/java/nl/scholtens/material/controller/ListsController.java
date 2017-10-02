package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.CarForm;
import nl.scholtens.material.formobject.LocForm;
import nl.scholtens.material.formobject.OperatorForm;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import nl.scholtens.material.service.OperatorService;
import nl.scholtens.material.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ListsController {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private SetupService setupService;


    @RequestMapping(value = "/locs", method = RequestMethod.GET)
    public ModelAndView getLocLijst(ModelAndView model) throws IOException {
        LocForm locForm = new LocForm();
        locForm.setLocomotives(locService.getLocList(getXmlPath()));

        model.addObject("form", locForm);
        model.setViewName("loclistView");
        return model;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView getCarsList(ModelAndView model) throws IOException {
        CarForm carForm = new CarForm();
        carForm.setCars(carService.getCarList(getXmlPath()));

        model.addObject("form", carForm);
        model.setViewName("carlistView");
        return model;
    }

    @RequestMapping(value = "/operators", method = RequestMethod.GET)
    public  ModelAndView getOperatorsList(ModelAndView model) {
        OperatorForm operatorForm = new OperatorForm();
        operatorForm.setOperators(operatorService.getOperatorList(getXmlPath()));

        model.addObject("form", operatorForm);
        model.setViewName("operatorListView");
        return model;
    }

    @RequestMapping(value = "/image/{imageName}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File(getImagePath() + imageName + ".png");
        return Files.readAllBytes(file.toPath());
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
