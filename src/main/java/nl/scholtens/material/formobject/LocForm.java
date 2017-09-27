package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Decoder;
import nl.scholtens.material.domain.Locomtive;

import java.io.IOException;
import java.util.List;

public class LocForm extends Body{

    private List<Locomtive> locomotives;

    private Locomtive locomtive;

    private Decoder decoder;

    public LocForm() throws IOException {
        super();
    }


    public List<Locomtive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(List<Locomtive> locomotives) {
        this.locomotives = locomotives;
    }
}
