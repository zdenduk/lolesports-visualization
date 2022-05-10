
package cvut.fel.davidzde.pojos;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Participant {

    @SerializedName("participantId")
    @Expose
    private int participantId;
    @SerializedName("totalGold")
    @Expose
    private int totalGold;
    @SerializedName("level")
    @Expose
    private int level;
    @SerializedName("kills")
    @Expose
    private int kills;
    @SerializedName("deaths")
    @Expose
    private int deaths;
    @SerializedName("assists")
    @Expose
    private int assists;
    @SerializedName("creepScore")
    @Expose
    private int creepScore;
    @SerializedName("currentHealth")
    @Expose
    private int currentHealth;
    @SerializedName("maxHealth")
    @Expose
    private int maxHealth;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getCreepScore() {
        return creepScore;
    }

    public void setCreepScore(int creepScore) {
        this.creepScore = creepScore;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

}
