package cvut.fel.davidzde.util.graphs;

import com.sun.org.apache.xpath.internal.operations.Bool;
import cvut.fel.davidzde.pojos.GameData;
import cvut.fel.davidzde.util.GameAttribute;
import cvut.fel.davidzde.util.TeamInfo;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LineGraphUtil {
    INSTANCE;

    private final int xSize = 1920;
    private final int ySize = 900;

    private LineChart linechart;

    private TeamInfo[] teamInfos;
    private GameAttribute[] gameAttributes;

    Map<String, XYChart.Series> chartData;

    public LineChart getLinechart() {
        return linechart;
    }

    public void initGraph(String xAxisLabel, String yAxisLabel) {
        //Defining X axis
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(xAxisLabel);

        //Defining y axis
        NumberAxis yAxis = new NumberAxis(0, 100000, 1000);
        yAxis.setLabel(yAxisLabel);

        linechart = new LineChart(xAxis, yAxis);
        linechart.setPrefSize(1920, 900);
    }

    public void addData(List<GameData> gamesData, Map<String, Boolean> selectedTeams, String selectedAttribute) throws ParseException {
        // Setting series for each team (that is selected to be in graph)
        for (TeamInfo teamInfo : teamInfos) {
            if (selectedTeams.get(teamInfo.getTeamID())) {
                XYChart.Series<String, Number> series = new XYChart.Series();
                series.setName(teamInfo.getFullName());
                chartData.put(teamInfo.getTeamID(), series);
            }
        }

        for (GameData gameData : gamesData) {
            Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(gameData.getRfc460Timestamp());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            if (date.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-21")) >= 0 &&
                    date.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-06")) <= 0) {
                if (selectedTeams.get(gameData.getBlueTeamMetadata().getEsportsTeamId())) {
                    chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(date.toString(), gameData.getBlueTeam().getTotalGold()));
                }
                if (selectedTeams.get(gameData.getRedTeamMetadata().getEsportsTeamId())) {
                    chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(date.toString(), gameData.getRedTeam().getTotalGold()));
                }
            }
        }

        linechart.getData().addAll(chartData.values());
    }

    public void addTooltips() {
        for (XYChart.Series<String, Number> series : chartData.values()) {
            for (XYChart.Data<String, Number> entry : series.getData()) {
                Tooltip t = new Tooltip(entry.getYValue().toString());
                Tooltip.install(entry.getNode(), t);
            }
        }
    }

    LineGraphUtil() {
        teamInfos = TeamInfo.values();
        gameAttributes = GameAttribute.values();

        chartData = new HashMap<>();
    }
}
