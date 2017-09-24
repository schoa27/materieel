package nl.scholtens.materieel.controller;

import nl.scholtens.materieel.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ImageController {

    @Autowired
    private SetupService setupService;

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

    protected String[] readSetupFile() {
        return setupService.readSetupFile();
    }
}
