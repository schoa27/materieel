package nl.scholtens.materieel.domein;

public class Locomtief {
    private String id;

    private String number;

    private String aandrjving;

    public Locomtief(String id, String number, String aandrjving) {
        this.id = id;
        this.number = number;
        this.aandrjving = aandrjving;
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

    public String getAandrjving() {
        return aandrjving;
    }

    public void setAandrjving(String aandrjving) {
        this.aandrjving = aandrjving;
    }
}
