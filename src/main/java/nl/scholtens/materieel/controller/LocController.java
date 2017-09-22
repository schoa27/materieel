package nl.scholtens.materieel.controller;

import nl.scholtens.materieel.domein.Locomtief;
import nl.scholtens.materieel.service.LocService;
import nl.scholtens.materieel.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LocController {

    @Autowired
    private LocService locService;

    @Autowired
    private SetupService setupService;

    @RequestMapping(value = "/locs", method = RequestMethod.GET)
    public ModelAndView getLocLijst(ModelAndView model) {

        List<Locomtief> locomtiefs = locService.ophalenLocLijst(getXmlPath());

        model.addObject("list", locomtiefs);
        model.addObject("imagePath",getImagePath());
        model.setViewName("loclistView");
        return model;
    }

    private String getXmlPath( ) {
        final String[] paths = readSetupFile();
        return paths[0];
    }

    private String getImagePath( ) {
        final String[] paths = readSetupFile();
        return paths[1];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }

}
