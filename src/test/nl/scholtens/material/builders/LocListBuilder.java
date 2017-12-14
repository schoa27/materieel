package nl.scholtens.material.builders;

import nl.scholtens.material.domain.Locomotive;

import java.util.ArrayList;
import java.util.List;

public class LocListBuilder {

       public static List<Locomotive> getLocomotives() {
        List<Locomotive>  locomotives = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Locomotive locomotive = new Locomotive();
            locomotive.setId(i);
            locomotive.setLocid(String.valueOf(i));
            locomotive.setImage(String.valueOf(i));
            locomotives.add(locomotive);
        }
        return locomotives;
    }
}
