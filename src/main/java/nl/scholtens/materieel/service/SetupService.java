package nl.scholtens.materieel.service;

public interface SetupService {

    void writeSetupFile(String pathXml, String pathImage);

    String[] readSetupFile();
}
