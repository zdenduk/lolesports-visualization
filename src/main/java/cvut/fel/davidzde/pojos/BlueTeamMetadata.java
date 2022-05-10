
package cvut.fel.davidzde.pojos;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class BlueTeamMetadata {

    @SerializedName("esportsTeamId")
    @Expose
    private String esportsTeamId;
    @SerializedName("participantMetadata")
    @Expose
    private List<ParticipantMetadatum> participantMetadata = null;

    public String getEsportsTeamId() {
        return esportsTeamId;
    }

    public void setEsportsTeamId(String esportsTeamId) {
        this.esportsTeamId = esportsTeamId;
    }

    public List<ParticipantMetadatum> getParticipantMetadata() {
        return participantMetadata;
    }

    public void setParticipantMetadata(List<ParticipantMetadatum> participantMetadata) {
        this.participantMetadata = participantMetadata;
    }

}
