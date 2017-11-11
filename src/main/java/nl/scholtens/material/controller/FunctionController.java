package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.CarForm;
import nl.scholtens.material.formobject.LocForm;
import nl.scholtens.material.formobject.SessionForm;
import nl.scholtens.material.service.CarService;
import nl.scholtens.material.service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FunctionController extends IoController {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Value("${build.version}")
    private String buildVersion;


    @RequestMapping(value = "/function/{item}", method = RequestMethod.GET)
    public ModelAndView getFunctions(@PathVariable(value = "item") String item, ModelAndView model, HttpServletRequest request) {

        if (item.substring(0, 3).equals("loc")) {
            LocForm form = new LocForm(buildVersion, getSessionForm(request).getDate()
                    , locService.getLoc(item.substring(4), getXmlPath()));
            model.addObject("locform", form);
            model.addObject("carform", new CarForm(null, null));
            model.addObject("id","loc");
            model.setViewName("functionlistView");
        }

        if (item.substring(0, 3).equals("car")) {
            CarForm form = new CarForm(buildVersion, getSessionForm(request).getDate()
                    , carService.getCarById(item.substring(4), getXmlPath()));
            model.addObject("carform", form);
            model.addObject("locform", new LocForm(null,null));
            model.addObject("id","car");
            model.setViewName("functionlistView");
        }
        return model;
    }


    private SessionForm getSessionForm(HttpServletRequest request) {
        return (SessionForm) request.getSession().getAttribute("sessionform");
    }
}
