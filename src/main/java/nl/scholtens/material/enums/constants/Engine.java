package nl.scholtens.material.enums.constants;

public enum Engine {
    STEAM("1e"),
    ELECTRIC("2e"),
    DIESEL("3e"),
    BATTERY("4e");

    private String engine;

    Engine(String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }
}
