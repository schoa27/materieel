package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.CarForm;
import nl.scholtens.material.formobject.LocForm;
import nl.scholtens.material.formobject.OperatorForm;
import nl.scholtens.material.formobject.SessionForm;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import nl.scholtens.material.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ListsController extends IoController {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Autowired
    private OperatorService operatorService;

    @Value("${build.version}")
    private String buildVersion;

    @RequestMapping(value = "/locs", method = RequestMethod.GET)
    public ModelAndView getLocLijst(HttpServletRequest request, ModelAndView model) throws IOException {

        LocForm locForm = new LocForm(buildVersion, getSessionForm(request).getDate());
        locForm.setLocomotives(locService.getLocList(getXmlPath()));

        model.addObject("form", locForm);
        model.setViewName("loclistView");
        return model;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView getCarsList(HttpServletRequest request, ModelAndView model) throws IOException {
        CarForm carForm = new CarForm(buildVersion, getSessionForm(request).getDate());
        carForm.setWaggons(carService.getCarList(getXmlPath()));

        model.addObject("form", carForm);
        model.setViewName("carlistView");
        return model;
    }

    @RequestMapping(value = "/operators", method = RequestMethod.GET)
    public  ModelAndView getOperatorsList(HttpServletRequest request, ModelAndView model) {
        OperatorForm operatorForm = new OperatorForm(buildVersion, getSessionForm(request).getDate());
        operatorForm.setOperatorTrains(operatorService.getOperatorList(getXmlPath()));

        model.addObject("form", operatorForm);
        model.setViewName("operatorListView");
        return model;
    }

    private SessionForm getSessionForm(HttpServletRequest request) {
        return (SessionForm) request.getSession().getAttribute("sessionform");
    }
}
