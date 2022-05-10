
package cvut.fel.davidzde.pojos;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RedTeam {

    @SerializedName("totalGold")
    @Expose
    private int totalGold;
    @SerializedName("inhibitors")
    @Expose
    private int inhibitors;
    @SerializedName("towers")
    @Expose
    private int towers;
    @SerializedName("barons")
    @Expose
    private int barons;
    @SerializedName("totalKills")
    @Expose
    private int totalKills;
    @SerializedName("dragons")
    @Expose
    private List<String> dragons = null;
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = null;

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    public int getInhibitors() {
        return inhibitors;
    }

    public void setInhibitors(int inhibitors) {
        this.inhibitors = inhibitors;
    }

    public int getTowers() {
        return towers;
    }

    public void setTowers(int towers) {
        this.towers = towers;
    }

    public int getBarons() {
        return barons;
    }

    public void setBarons(int barons) {
        this.barons = barons;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public List<String> getDragons() {
        return dragons;
    }

    public void setDragons(List<String> dragons) {
        this.dragons = dragons;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

}
