package cvut.fel.davidzde.util;

import cvut.fel.davidzde.util.graphs.GraphUtil;
import cvut.fel.davidzde.util.graphs.LineGraphUtil;

public enum GraphType {
    INSTANCE;

    GraphUtil selectedGraph;

    GraphType() {
        selectedGraph = LineGraphUtil.INSTANCE;
    }

    public GraphUtil getSelectedGraph() {
        return selectedGraph;
    }

    public void setSelectedGraph(GraphUtil selectedGraph) {
        this.selectedGraph = selectedGraph;
    }
}
