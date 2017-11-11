package nl.scholtens.material.domain;

public class DecoderFunction {

    private String fn;

    private String discription;

    public DecoderFunction() {
        super();
    }

    public DecoderFunction(String fn, String discription) {
        this.fn = fn;
        this.discription = discription;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
