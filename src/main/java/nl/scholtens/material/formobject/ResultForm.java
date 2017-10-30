package nl.scholtens.material.formobject;

import nl.scholtens.material.domain.Waggon;
import nl.scholtens.material.domain.Locomotive;

import java.util.ArrayList;
import java.util.List;

public class ResultForm extends Body {

    private List<Locomotive> locomotives = new ArrayList<>();

    private List<Waggon> waggons = new ArrayList<>();

    public ResultForm(String version, String date) {
        super(version, date);
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public List<Waggon> getWaggons() {
        return waggons;
    }

    public void setWaggons(List<Waggon> waggons) {
        this.waggons = waggons;
    }
}
