package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Locomotive;

import java.io.IOException;
import java.util.List;

public class LocForm extends Body {

    private List<Locomotive> locomotives;

    private Locomotive locomotive;

    public LocForm() throws IOException {
        super();
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
