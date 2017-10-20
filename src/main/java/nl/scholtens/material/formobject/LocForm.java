package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Locomotive;

import java.util.List;

public class LocForm extends Body {

    private List<Locomotive> locomotives;

    private Locomotive locomotive;

    public LocForm(String version ,String date) {
        super(version, date);
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

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

}
