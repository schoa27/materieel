package nl.scholtens.materieel.controller;

import nl.scholtens.materieel.domein.Locomtief;
import nl.scholtens.materieel.service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LocController extends ImageController {

    @Autowired
    private LocService locService;

//    @Autowired
//    private SetupService setupService;

    @RequestMapping(value = "/locs", method = RequestMethod.GET)
    public ModelAndView getLocLijst(ModelAndView model) {
        List<Locomtief> locomtiefs = locService.ophalenLocLijst(getXmlPath());

        model.addObject("list", locomtiefs);
        model.setViewName("loclistView");
        return model;
    }


    private String getXmlPath( ) {
        final String[] paths = readSetupFile();
        return paths[0];
    }

}
