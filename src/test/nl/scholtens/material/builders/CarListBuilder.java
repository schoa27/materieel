package nl.scholtens.material.builders;

import nl.scholtens.material.domain.Waggon;

import java.util.ArrayList;
import java.util.List;

public class CarListBuilder {

    public static List<Waggon> getCars() {
        List<Waggon> waggons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Waggon waggon = new Waggon();
            waggon.setId(i);
            waggon.setCarid(String.valueOf(i));
            waggon.setImage(String.valueOf(i));
            waggons.add(waggon);
        }
        return waggons;
    }
}
