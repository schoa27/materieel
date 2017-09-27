package nl.scholtens.material.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailsController {


    @RequestMapping(value = "/detail/loc/{loc}", method = RequestMethod.GET)
    public ModelAndView locDetails(@PathVariable(value = "loc") String locId, ModelAndView model) {


        model.setViewName("locDetails");
        return model;
    }

    @RequestMapping(value = "/detail/car/{car}", method = RequestMethod.GET)
    public ModelAndView carDetails(@PathVariable(value = "car") String carId, ModelAndView model) {


        model.setViewName("carDetails");
        return model;
    }

    @RequestMapping(value = "/detail/operator/{operator}", method = RequestMethod.GET)
    public ModelAndView operatorDetails(@PathVariable(value = "operator") String operatorId, ModelAndView model) {


        model.setViewName("operatorDetails");
        return model;
    }
}
