import com.google.gson.Gson;
import cvut.fel.davidzde.pojos.GameData;
import cvut.fel.davidzde.util.GameAttribute;
import cvut.fel.davidzde.util.TeamInfo;
import cvut.fel.davidzde.util.graphs.LineGraphUtil;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.*;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws ParseException {
        primaryStage.setTitle("LoL Esports visualization");

        // Getting data
        String[] gameIDs = new String[]{"107417059263300160", "107417059263300166", "107417059263300142", "107417059263300120", "107417059263300172",
                "107417059263365742", "107417059263365716", "107417059263300146", "107417059263300124", "107417059263365734",
                "107417059263300156", "107417059263365712", "107417059263300132", "107417059263300140", "107417059263365740",
                "107417059263300158", "107417059263300168", "107417059263365738", "107417059263300118", "107417059263365714",
                "107417059263365736", "107417059263300152", "107417059263300130", "107417059263300144", "107417059263365730",
                "107417059263300174", "107417059263300154", "107417059263365726", "107417059263365720", "107417059263300134",
                "107417059263300136", "107417059263300170", "107417059263431354", "107417059263365754", "107417059263365776",
                "107417059263365786", "107417059263365792", "107417059263365774", "107417059263431344", "107417059263431350",
                "107417059263365748", "107417059263365790", "107417059263365746", "107417059263365768", "107417059263431368",
                "107417059263365798", "107417059263431342", "107417059263365744", "107417059263431364", "107417059263431340",
                "107417059263431362", "107417059263365778", "107417059263365766", "107417059263365758", "107417059263431366",
                "107417059263365784", "107417059263365794", "107417059263431356", "107417059263365756", "107417059263365770",
                "107417059263365800", "107417059263365780", "107417059263431358", "107417059263365752", "107417059263431348",
                "107417059263365764", "107417059263365788", "107417059263365772", "107417059263365750", "107417059263431360",
                "107417059263365782", "107417059263431338", "107417059263431352", "107417059263365760", "107417059263431346",
                "107417059263365762", "107417059263365796", "107417293272826573", "107417293272826579", "107417293272826585"};

        List<GameData> gamesData = new ArrayList<>();

        // TODO class for deserializing
        try {
            for (String gameID : gameIDs) {
                // create Gson instance
                Gson gson = new Gson();

                // create a reader
                String path = "data/" + gameID + ".json";
                InputStream inputStream = getClass().getResourceAsStream(path);
                Reader reader = new BufferedReader(new InputStreamReader(inputStream));

                // convert JSON file to GameData class
                GameData gameData = gson.fromJson(reader, GameData.class);

                gamesData.add(gameData);

                // close reader
                reader.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        TeamInfo[] teamInfos = TeamInfo.values();
        GameAttribute[] gameAttributes = GameAttribute.values();

        // Map of selected teams, initially all teams are selected
        // String represents TeamID
        Map<String, Boolean> selectedTeams = new HashMap<>();
        for (TeamInfo teamInfo : teamInfos) {
            selectedTeams.put(teamInfo.getTeamID(), true);
        }

        // Creating toggles for each team (X axis)
        HBox teamsToggle = new HBox();
        teamsToggle.setSpacing(10);
        teamsToggle.setAlignment(Pos.CENTER);
        for (TeamInfo teamInfo : teamInfos) {
            CheckBox cb = new CheckBox(teamInfo.getFullName());
            cb.setSelected(true);
            teamsToggle.getChildren().add(cb);

            // Set listener for changes
            cb.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                selectedTeams.put(teamInfo.getTeamID(), !selectedTeams.get(teamInfo.getTeamID()));
            });
        }

        // Creating radio buttons to select attribute (Y axis)
        HBox attributesToggle = new HBox();
        attributesToggle.setSpacing(10);
        attributesToggle.setAlignment(Pos.CENTER);
        ToggleGroup tg = new ToggleGroup();
        for (GameAttribute gameAttribute : gameAttributes) {
            RadioButton rb = new RadioButton(gameAttribute.getInfoText());
            rb.setToggleGroup(tg);
            attributesToggle.getChildren().add(rb);
        }

        LineGraphUtil.INSTANCE.initGraph("Date", "Total Gold");
        LineGraphUtil.INSTANCE.addData(gamesData, selectedTeams, "Total Gold");
        LineGraphUtil.INSTANCE.addTooltips();

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        vBox.getChildren().add(LineGraphUtil.INSTANCE.getLinechart());
        vBox.getChildren().add(teamsToggle);
        vBox.getChildren().add(attributesToggle);

        Group root = new Group(vBox);

        Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
