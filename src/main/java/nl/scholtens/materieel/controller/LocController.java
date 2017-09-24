package nl.scholtens.materieel.controller;

import nl.scholtens.materieel.domein.Car;
import nl.scholtens.materieel.domein.Locomtive;
import nl.scholtens.materieel.service.CarService;
import nl.scholtens.materieel.service.LocService;
import nl.scholtens.materieel.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
public class LocController  {

    @Autowired
    private LocService locService;

    @Autowired
    private CarService carService;

    @Autowired
    private SetupService setupService;


    @RequestMapping(value = "/locs", method = RequestMethod.GET)
    public ModelAndView getLocLijst(ModelAndView model) {
        List<Locomtive> locomtiefs = locService.getLocList(getXmlPath());

        model.addObject("list", locomtiefs);
        model.setViewName("loclistView");
        return model;
    }


    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView carsList(ModelAndView model) {
        List<Car> cars = carService.getCarList(getXmlPath());

        model.addObject("list", cars);
        model.setViewName("carlistView");
        return model;
    }



    @RequestMapping(value = "/image/{imageName}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File(getImagePath() + imageName + ".png");
        return Files.readAllBytes(file.toPath());
    }

    private String getImagePath( ) {
        final String[] paths = readSetupFile();
        return paths[1];
    }

    private String getXmlPath( ) {
        final String[] paths = readSetupFile();
        return paths[0];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }
}
