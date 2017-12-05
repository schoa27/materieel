package nl.scholtens.material.controller;

import nl.scholtens.material.domain.OperatorTrain;
import nl.scholtens.material.formobject.OperatorForm;
import nl.scholtens.material.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OperatorController extends IoController {

    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/operator/{item}", method = RequestMethod.GET)
    public ModelAndView getOperatorDetails(@PathVariable(value = "item") String item, ModelAndView model, HttpServletRequest request) {

        OperatorTrain opertorByLocId = operatorService.getOpertorByLocId(item.substring(4), getXmlPath());
        OperatorForm form = new OperatorForm(opertorByLocId);
        model.addObject("form", form);
        model.setViewName("OperatorView");
        return model;
    }
}
