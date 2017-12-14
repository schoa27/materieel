package nl.scholtens.material.controller;

import nl.scholtens.material.formobject.LocForm;
import nl.scholtens.material.service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SlavesController extends IoController {

    @Autowired
    private LocService locService;

    @RequestMapping(value = "/slaves/{item}", method = RequestMethod.GET)
    public ModelAndView getSlaveLocs(@PathVariable String item,  ModelAndView model ) {
        LocForm form = new LocForm(locService.getSlaveLocs(item, getXmlPath()));
        model.addObject("form", form);
        model.setViewName("tractionDetails");
        return model;
    }
}
