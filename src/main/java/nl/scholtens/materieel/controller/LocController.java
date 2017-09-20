package nl.scholtens.materieel.controller;

import nl.scholtens.materieel.domein.Locomtief;
import nl.scholtens.materieel.service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LocController {

    @Autowired
    private LocService locService;

    @RequestMapping(value = "/locs", method = RequestMethod.GET)
    public String getLocLijst(Model model) {

        List<Locomtief> locomtiefs = locService.ophalenLocLijst("/data/Data/rocrail/loc.xml");
        model.addAttribute("lijst", locomtiefs);
        return "loclijstView";
    }

}
