package nl.scholtens.materieel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CarController {

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView carsList(HttpServletRequest request, ModelAndView model) {

        model.setViewName("carlistView");
        return model;
    }
}


