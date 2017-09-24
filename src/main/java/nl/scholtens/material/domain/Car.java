package nl.scholtens.material.domain;

public class Car extends Decoder{

    private String id;

    private String company;

    private String type;

    private String manufactor;

    private boolean digital;

    private String image;

    public Car() {
        super();
    }

    public Car(String id, String company, String type, boolean digital) {
        this.id = id;
        this.company = company;
        this.type = type;
        this.digital = digital;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
