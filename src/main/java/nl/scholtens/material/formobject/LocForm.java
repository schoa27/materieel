package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomotive;

import java.util.ArrayList;
import java.util.List;

public class LocForm extends Body {

    private List<Locomotive> locomotives = new ArrayList<>();

    private Locomotive locomotive = new Locomotive();

    private Decoder decoder;

    private String image;

    private String bigImage;

    public LocForm(String version, String date) {
        super(version, date);
    }

    public LocForm(String version, String date, Locomotive locomotive) {
        super(version, date);
        setLocomotive(locomotive);
        setDecoder(locomotive);
        setImage(locomotive);
        setBigImage(getImage());
    }

    public LocForm(Locomotive locomotive) {
        setLocomotive(locomotive);
        setImage(locomotive);
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    private void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public Decoder getDecoder() {
        return decoder;
    }

    private void setDecoder(Locomotive locomotive) {
        if (getLocomotive() != null) {
            decoder = locomotive.getDecoder();
        }
    }

    public String getImage() {
        return image;
    }

    private void setImage(Locomotive locomotive) {
        if (getLocomotive() != null) {
            image = locomotive.getImage();
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
