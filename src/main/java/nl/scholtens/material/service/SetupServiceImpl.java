package nl.scholtens.material.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class SetupServiceImpl implements SetupService {

    private static Logger logger = LogManager.getLogger(SetupServiceImpl.class);

    private final String FILENAME = "material.ini";


    @Override
    public String getDate(String location) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, d MMMM ", Locale.US);

        if (location != null) {
           dateFormatter = new SimpleDateFormat("EEEE, d MMMM ", Locale.forLanguageTag(location));
        }
        return dateFormatter.format(new Date());
    }

    @Override
    public void writeSetupFile(String pathXml, String pathImage) {

        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(FILENAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            Writer writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(pathXml);
            bufferedWriter.newLine();
            bufferedWriter.write(pathImage);
        } catch (IOException e) {
            logger.error("error write file");
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception ex) {
                logger.error("error closing file");
                ex.fillInStackTrace();
            }
        }
    }

    @Override
    public String[] readSetupFile() {
        String[] paths = new String[2];

        int row = 0;
        String path = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            while ((path = br.readLine()) != null) {
                paths[row] = path;
                row++;
            }
        } catch (FileNotFoundException e) {
            logger.error("Unable to find the file methode readSetupFile");
        } catch (IOException e) {
            logger.error("Unable to read the file methode readSetupFile");
        }
        return paths;
    }

    @Override
    public boolean isFileEmpty() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            return br.readLine() == null;
        } catch (FileNotFoundException e) {
            logger.error("Unable to find the file methode isFileEmpty");
        } catch (IOException e) {
            logger.error("Unable to read the file methode isFileEmpty");
        }
        return true;
    }
}
