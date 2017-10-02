package nl.scholtens.material.formobject;

import java.io.*;

public class Body {

    private Header header = new Header();

    private Bottom bottom = new Bottom();


    public Body() {
        initHeaderBottom();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    private void initHeaderBottom() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/material.txt"));
            header.setVersion(br.readLine());
            bottom.setName(br.readLine());
            bottom.setYear(br.readLine());
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName material.txt");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName material.txt");
        }

    }
}
