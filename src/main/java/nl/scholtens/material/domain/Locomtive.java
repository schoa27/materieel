package nl.scholtens.material.domain;

public class Locomtive {
    private String id;

    private String number;

    private String decoderAdres;

    private String typeNummer;

    private String fabrikant;

    private String aandrijving;

    private String afbeelding;

    public Locomtive() {
        super();
    }

    public Locomtive(String id, String number, String aandrjving) {
        this.id = id;
        this.number = number;
        this.aandrijving = aandrjving;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAandrijving() {
        return aandrijving;
    }

    public String getDecoderAdres() {
        return decoderAdres;
    }

    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public void setDecoderAdres(String decoderAdres) {
        this.decoderAdres = decoderAdres;

    }

    public String getTypeNummer() {
        return typeNummer;
    }

    public void setTypeNummer(String typeNummer) {
        this.typeNummer = typeNummer;
    }

    public String getFabrikant() {
        return fabrikant;
    }

    public void setFabrikant(String fabrikant) {
        this.fabrikant = fabrikant;
    }

    public void setAandrijving(String aandrjving) {
        this.aandrijving = aandrijving;
    }


}
