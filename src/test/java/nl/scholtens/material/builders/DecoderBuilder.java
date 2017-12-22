package nl.scholtens.material.builders;

import nl.scholtens.material.domain.Decoder;

public class DecoderBuilder {

    public static Decoder getDecoder() {
        Decoder decoder = new Decoder();
        decoder.setAddress(1);
        return decoder;
    }
}
