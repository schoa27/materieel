package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.domain.Decoder;

import java.util.ArrayList;
import java.util.List;

public class CarForm extends Body {

    private List<Waggon> waggons = new ArrayList<>();

    private Waggon waggon = new Waggon();

    private Decoder decoder;

    private String image;

    private String bigImage;

    public CarForm(String version, String date) {
        super(version, date);
    }

    public CarForm(String version, String date, Waggon waggon) {
        super(version, date);
        setWaggon(waggon);
        setDecoder(waggon);
        setImage(waggon);
        setBigImage(getImage());
    }

    public List<Waggon> getWaggons() {
        return waggons;
    }

    public void setWaggons(List<Waggon> waggons) {
        this.waggons = waggons;
    }

    public Waggon getWaggon() {
        return waggon;
    }

    public void setWaggon(Waggon waggon) {
        this.waggon = waggon;
    }

    public Decoder getDecoder() {
        return decoder;
    }

    private void setDecoder(Waggon waggon) {
        if (getWaggon() != null) {
            decoder = waggon.getDecoder();
        }
    }

    public String getImage() {
        return image;
    }

    private void setImage(Waggon waggon) {
        if (getWaggon() != null) {
            image = waggon.getImage();
        }
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String image) {

        if (getImage() != null) {
            bigImage = getImage().substring(0, getImage().length() - 6) + ".png";
        }
    }
}
