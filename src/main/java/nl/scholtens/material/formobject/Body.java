package nl.scholtens.material.formobject;

public class Body {


    private Header header;

    public Body(String version) {
        header = new Header();
        header.setVersion(version);
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
