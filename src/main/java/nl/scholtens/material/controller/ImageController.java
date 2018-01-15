package nl.scholtens.material.controller;

import nl.scholtens.material.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @Autowired
    private SetupService setupService;


    @RequestMapping(value = "/smallImage/{imageName}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getSmallImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File(getSmallImagePath() + imageName + ".png");
        return Files.readAllBytes(file.toPath());
    }

    @RequestMapping(value = "/largeImage/{imageName}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] getLargeImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        File file = new File(getLargeImagePath() + imageName + ".png");
        return Files.readAllBytes(file.toPath());
    }


    private String getSmallImagePath( ) {
        final String[] paths = readSetupFile();
        return paths[1];
    }

    private String getLargeImagePath( ) {
        final String[] paths = readSetupFile();
        return paths[2];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }
}
