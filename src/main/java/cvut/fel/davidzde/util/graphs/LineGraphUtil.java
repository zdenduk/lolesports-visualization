package cvut.fel.davidzde.util.graphs;

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

public enum LineGraphUtil implements GraphUtil{
    INSTANCE;

    private final int xSize = 1920;
    private final int ySize = 900;

    private LineChart linechart;

    private TeamInfo[] teamInfos;
    private GameAttribute[] gameAttributes;

    Map<String, XYChart.Series> chartData;

    CategoryAxis xAxis;
    NumberAxis yAxis;

    public LineChart getGraph() {
        return linechart;
    }

    public void initGraph(String xAxisLabel, String yAxisLabel) {
        //Defining X axis
        xAxis = new CategoryAxis();
        xAxis.setLabel(xAxisLabel);

        //Defining y axis
        yAxis = new NumberAxis(0, 100000, 1000);
        yAxis.setLabel(yAxisLabel);

        linechart = new LineChart(xAxis, yAxis);
        linechart.setPrefSize(1920, 900);
        linechart.setAnimated(false);
    }

    public void addData(List<GameData> gamesData, Map<String, Boolean> selectedTeams, String selectedAttribute) {
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
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = formatter.parse(gameData.getRfc460Timestamp());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            try {
                if (date.compareTo(formatter.parse("2022-01-21")) >= 0 &&
                        date.compareTo(formatter.parse("2022-03-06")) <= 0) {
                    if (selectedTeams.get(gameData.getBlueTeamMetadata().getEsportsTeamId())) {
                        if (selectedAttribute.equals(GameAttribute.BARONS.getInfoText())) {
                            chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getBlueTeam().getBarons()));
                        } else if (selectedAttribute.equals(GameAttribute.DRAGONS.getInfoText())) {
                            chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getBlueTeam().getDragons().size()));
                        } else if (selectedAttribute.equals(GameAttribute.TOTAL_GOLD.getInfoText())) {
                            chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getBlueTeam().getTotalGold()));
                        } else if (selectedAttribute.equals(GameAttribute.INHIBITORS.getInfoText())) {
                            chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getBlueTeam().getInhibitors()));
                        } else if (selectedAttribute.equals(GameAttribute.TOTAL_KILLS.getInfoText())) {
                            chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getBlueTeam().getTotalKills()));
                        } else if (selectedAttribute.equals(GameAttribute.TOWERS.getInfoText())) {
                            chartData.get(gameData.getBlueTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getBlueTeam().getTowers()));
                        }
                    }
                    if (selectedTeams.get(gameData.getRedTeamMetadata().getEsportsTeamId())) {
                        if (selectedAttribute.equals(GameAttribute.BARONS.getInfoText())) {
                            chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getRedTeam().getBarons()));
                        } else if (selectedAttribute.equals(GameAttribute.DRAGONS.getInfoText())) {
                            chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getRedTeam().getDragons().size()));
                        } else if (selectedAttribute.equals(GameAttribute.TOTAL_GOLD.getInfoText())) {
                            chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getRedTeam().getTotalGold()));
                        } else if (selectedAttribute.equals(GameAttribute.INHIBITORS.getInfoText())) {
                            chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getRedTeam().getInhibitors()));
                        } else if (selectedAttribute.equals(GameAttribute.TOTAL_KILLS.getInfoText())) {
                            chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getRedTeam().getTotalKills()));
                        } else if (selectedAttribute.equals(GameAttribute.TOWERS.getInfoText())) {
                            chartData.get(gameData.getRedTeamMetadata().getEsportsTeamId()).getData().add(new XYChart.Data(formatter.format(date), gameData.getRedTeam().getTowers()));
                        }
                    }
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        linechart.getData().addAll(chartData.values());
    }

    public void clearData() {
        chartData.clear();
        linechart.getData().clear();
    }

    public void updateYAxis(String selectedAttribute) {
        yAxis.setLabel(selectedAttribute);
        if (selectedAttribute.equals(GameAttribute.BARONS.getInfoText())) {
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(3);
            yAxis.setTickUnit(1);
        } else if (selectedAttribute.equals(GameAttribute.DRAGONS.getInfoText())) {
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(6);
            yAxis.setTickUnit(1);
        } else if (selectedAttribute.equals(GameAttribute.TOTAL_GOLD.getInfoText())) {
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(100000);
            yAxis.setTickUnit(1000);
        } else if (selectedAttribute.equals(GameAttribute.INHIBITORS.getInfoText())) {
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(5);
            yAxis.setTickUnit(1);
        } else if (selectedAttribute.equals(GameAttribute.TOTAL_KILLS.getInfoText())) {
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(50);
            yAxis.setTickUnit(5);
        } else if (selectedAttribute.equals(GameAttribute.TOWERS.getInfoText())) {
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(15);
            yAxis.setTickUnit(1);
        }
    }

    public void addTooltips() {
        for (XYChart.Series<String, Number> series : chartData.values()) {
            for (XYChart.Data<String, Number> entry : series.getData()) {
                Tooltip t = new Tooltip(series.getName() + ": " + entry.getYValue().toString());
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
