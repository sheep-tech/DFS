package fontys.fhict.nl.domain;

import java.util.List;

public class Node {
    private boolean visited;
    private List<Node> vertex;

    public Node(List<Node> vertex) {
        this.visited = false;
        this.vertex = vertex;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getVertex() {
        return vertex;
    }

    public void setVertex(List<Node> vertex) {
        this.vertex = vertex;
    }
}
