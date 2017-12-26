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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class DetailsController extends IoController {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Autowired
    private OperatorService operatorService;

    @Value("${build.version}")
    private String buildVersion;

    @RequestMapping(value = "/{item}", method = RequestMethod.GET)
    public ModelAndView details(@PathVariable(value = "item") String item, ModelAndView model, HttpServletRequest request) throws IOException {

        if (item.substring(0, 3).equals("loc")) {
            LocForm form = new LocForm(buildVersion, getSessionForm(request).getDate()
                    , locService.getLocById(item.substring(4), getXmlPath()));
            model.addObject("form", form);
            model.addObject("id", "loc");
            model.setViewName("locDetails");
        }

        if (item.substring(0, 3).equals("car")) {
            CarForm form = new CarForm(buildVersion, getSessionForm(request).getDate()
                    , carService.getCarById(item.substring(4), getXmlPath()));
            model.addObject("form", form);
            model.addObject("id", "car");
            model.setViewName("carDetails");
        }

        if (item.substring(0, 3).equals("opr")) {
            OperatorForm form = new OperatorForm(buildVersion, getSessionForm(request).getDate()
                    , operatorService.getOperatorById(item.substring(4), getXmlPath()));
            form.getLocomotive().setOperator(true);
            model.addObject("form", form);
            model.addObject("id", "loc");
            model.setViewName("operatorDetails");
        }

        model.addObject("sessionform", getSessionForm(request));
        return model;
    }

    private SessionForm getSessionForm(HttpServletRequest request) {
        return (SessionForm) request.getSession().getAttribute("sessionform");
    }

}
