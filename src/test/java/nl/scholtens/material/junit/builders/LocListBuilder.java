package nl.scholtens.material.junit.builders;

import nl.scholtens.material.domain.Locomotive;
import nl.scholtens.material.junit.builders.DecoderBuilder;

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
            locomotive.setLength(i);
            locomotive.setOwner("Owner");
            locomotive.setCatalogNumber("CT12345");
            locomotive.setDecoder(DecoderBuilder.getDecoder());
            locomotives.add(locomotive);
        }
        return locomotives;
    }
}
