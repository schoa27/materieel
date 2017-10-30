package nl.scholtens.material.enums.constants;

public enum Protocol {
    P("ServerDefined"),
    M("Motorola"),
    N("NMRA-DCC"),
    L("NMRA-DCC Long"),
    A("Analog"),
    S("SX1"),
    X("SX2"),
    F("MFX"),
    C("Waggon");

    private String protocol;

    Protocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }
}

