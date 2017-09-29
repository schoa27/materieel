package nl.scholtens.material.domain;

public class Decoder {

    private String manufacture;

    private String type;

    private Integer address;

    private Integer speedSteps;

    private Integer functionCount;

    private String protocol;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getSpeedSteps() {
        return speedSteps;
    }

    public void setSpeedSteps(Integer speedSteps) {
        this.speedSteps = speedSteps;
    }

    public Integer getFunctionCount() {
        return functionCount;
    }

    public void setFunctionCount(Integer functionCount) {
        this.functionCount = functionCount;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
