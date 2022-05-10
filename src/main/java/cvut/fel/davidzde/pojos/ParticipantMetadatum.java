
package cvut.fel.davidzde.pojos;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ParticipantMetadatum {

    @SerializedName("participantId")
    @Expose
    private int participantId;
    @SerializedName("esportsPlayerId")
    @Expose
    private String esportsPlayerId;
    @SerializedName("summonerName")
    @Expose
    private String summonerName;
    @SerializedName("championId")
    @Expose
    private String championId;
    @SerializedName("role")
    @Expose
    private String role;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getEsportsPlayerId() {
        return esportsPlayerId;
    }

    public void setEsportsPlayerId(String esportsPlayerId) {
        this.esportsPlayerId = esportsPlayerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
