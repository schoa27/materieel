package nl.scholtens.material.service;

public interface SetupService {

    void writeSetupFile(String pathXml, String pathImage);

    String[] readSetupFile();

    boolean isFileEmpty();

    String getDate(String lang);
}
