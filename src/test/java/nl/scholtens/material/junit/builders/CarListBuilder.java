package nl.scholtens.material.junit.builders;

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
            waggon.setLength(i);
            waggon.setManufactor("Owner");
            waggon.setCatalognr("CT12345");
            waggon.setDecoder(DecoderBuilder.getDecoder());
            waggons.add(waggon);
        }
        return waggons;
    }
}
