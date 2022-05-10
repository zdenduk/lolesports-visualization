package cvut.fel.davidzde.util;

public enum TeamInfo {
    AST("Astralis", "101383793569248484"), XL("Excel Esports", "101383793572656373"),
    FNC("Fnatic", "98767991866488695"), G2("G2 Esports", "98767991926151025"),
    MAD("MAD Lions", "103461966965149786"), MSF("Misfits Gaming", "98767991940181526"),
    RGE("Rogue", "101383793574360315"), SK("SK Gaming", "101383793567806688"),
    BDS("Team BDS", "107563714667537640"), VIT("Team Vitality", "99322214695067838");

    private final String fullName;
    private final String teamID;

    TeamInfo(String fullName, String teamID) {
        this.fullName = fullName;
        this.teamID = teamID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTeamID() {
        return teamID;
    }
}
