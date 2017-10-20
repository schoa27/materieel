package nl.scholtens.material.formobject;

public class Body {


    private Header header;

    public Body(String version, String date) {
        header = new Header();
        header.setVersion(version);
        header.setDate(date);

    }

    public Body() {
        super();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }


}
