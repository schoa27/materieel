package nl.scholtens.material.controller;

import nl.scholtens.material.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;

public class IoController {

    @Autowired
    private SetupService setupService;

    protected String getXmlPath( ) {
        final String[] paths = readSetupFile();
        return paths[0];
    }

    private String[] readSetupFile() {
        return setupService.readSetupFile();
    }

    public SetupService getSetupService() {
        return setupService;
    }
}
