package cvut.fel.davidzde.util;

public enum GameAttribute {
    TOTAL_GOLD("Total Gold"), INHIBITORS("Inhibitors"), TOWERS("Towers"), BARONS("Barons"), TOTAL_KILLS("Total Kills"), DRAGONS("Dragons");

    private final String infoText;

    GameAttribute(String infoText) {
        this.infoText = infoText;
    }

    public String getInfoText() {
        return infoText;
    }
}
