package cvut.fel.davidzde.util.graphs;

import cvut.fel.davidzde.pojos.GameData;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.Map;

public interface GraphUtil {
    public XYChart getGraph();

    public void initGraph(String xAxisLabel, String yAxisLabel);

    public void addData(List<GameData> gamesData, Map<String, Boolean> selectedTeams, String selectedAttribute);

    public void clearData();

    // TODO automatically resolve Y axis limits
    public void updateYAxis(String selectedAttribute);

    public void addTooltips();
}
