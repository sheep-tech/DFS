package fontys.fhict.nl.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Node {
    private char label;
    private boolean visited;
    private List<Node> child;

    public Node(char label) {
        this.label = label;
        this.visited = false;
        this.child = new ArrayList<>();
    }

    public Node(ArrayList<Node> child) {
        this.visited = false;
        this.child = child;
    }

    @Override
    public String toString() {
//        return "label: " + label + " num of child: " + child.size();
        return /*"label: " + */ label + "";
    }

    public void addChild(Node child) {
        this.child.add(child);
    }

    public Node getFirstUnvisitedChild() {
        for(Node node : this.child) {
            if(!node.isVisited())
                return node;
        }
        return null;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getChild() {
        return child;
    }
}
