package nl.scholtens.material.formobject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Header {

    private String version;

    private String date;

    public String getVersion() {

        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, d MMMM ");
        return dateFormatter.format(new Date());
    }

    public void setDate(String date) {
        this.date = date;
    }
}
