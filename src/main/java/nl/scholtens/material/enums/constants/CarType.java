package nl.scholtens.material.enums.constants;

public enum  CarType {
    PASSENGER("c1"),
    GOODS("c2");

    private String cartype;

    CarType(String cartype) {
        this.cartype = cartype;
    }

    public String getCartype() {
        return cartype;
    }
}
