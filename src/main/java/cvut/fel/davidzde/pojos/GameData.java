
package cvut.fel.davidzde.pojos;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class GameData {

    @SerializedName("patchVersion")
    @Expose
    private String patchVersion;
    @SerializedName("blueTeamMetadata")
    @Expose
    private BlueTeamMetadata blueTeamMetadata;
    @SerializedName("redTeamMetadata")
    @Expose
    private RedTeamMetadata redTeamMetadata;
    @SerializedName("rfc460Timestamp")
    @Expose
    private String rfc460Timestamp;
    @SerializedName("gameState")
    @Expose
    private String gameState;
    @SerializedName("blueTeam")
    @Expose
    private BlueTeam blueTeam;
    @SerializedName("redTeam")
    @Expose
    private RedTeam redTeam;

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    public BlueTeamMetadata getBlueTeamMetadata() {
        return blueTeamMetadata;
    }

    public void setBlueTeamMetadata(BlueTeamMetadata blueTeamMetadata) {
        this.blueTeamMetadata = blueTeamMetadata;
    }

    public RedTeamMetadata getRedTeamMetadata() {
        return redTeamMetadata;
    }

    public void setRedTeamMetadata(RedTeamMetadata redTeamMetadata) {
        this.redTeamMetadata = redTeamMetadata;
    }

    public String getRfc460Timestamp() {
        return rfc460Timestamp;
    }

    public void setRfc460Timestamp(String rfc460Timestamp) {
        this.rfc460Timestamp = rfc460Timestamp;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public BlueTeam getBlueTeam() {
        return blueTeam;
    }

    public void setBlueTeam(BlueTeam blueTeam) {
        this.blueTeam = blueTeam;
    }

    public RedTeam getRedTeam() {
        return redTeam;
    }

    public void setRedTeam(RedTeam redTeam) {
        this.redTeam = redTeam;
    }

}
