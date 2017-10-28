package nl.scholtens.material.enums.constants;

public enum TrainType {
    NONE("0t"),
    OTHER("1t"),
    MIXED("2t"),
    POST("3t"),
    REGIONAL("4t"),
    GOODS("5t"),
    CLEANING("6t"),
    PERSON("7t"),
    ALL("8t"),
    LOCAL("9t"),
    ICE("10t"),
    LIGHTFREIGHT("11t"),
    SHUNTING("12t");


    private String traintype;

    TrainType(String traintype) {
        this.traintype = traintype;
    }

    public String getTraintype() {
        return traintype;
    }
}
