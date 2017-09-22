package nl.scholtens.materieel.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class SetupServiceImpl implements SetupService {

    @Override
    public void writeSetupFile(String pathXml, String pathImage) {

        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("materieel.ini");
            if (!file.exists()) {
                file.createNewFile();
            }
            Writer writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(pathXml);
            bufferedWriter.newLine();
            bufferedWriter.write(pathImage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception ex) {
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
            BufferedReader br = new BufferedReader( new FileReader("materieel.ini"));
            while( (path = br.readLine()) != null) {
                paths[row] = path;
                row++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }
        return paths;
    }
}
