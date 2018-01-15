package nl.scholtens.material.service;

public interface SetupService {

    void writeSetupFile(String[] paths);

    String[] readSetupFile();

    boolean isFileEmpty();

    String getDate(String lang);
}
