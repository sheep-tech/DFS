package fontys.fhict.nl.domain;

import java.util.*;

public class DFS {
    private String visitedHistory;
    private Stack<Node> stack;

    public DFS() {
        this.stack = new Stack<>();
        this.visitedHistory = new String();
    }

    public String visit(Node tree) {
        // First add root node in the stack
        stack.add(tree);

        recursiveVisit();

        return this.visitedHistory;
    }

    private void recursiveVisit() {
        // exit when stack is empty
        if (stack.empty())
            return;

        // get the top node of the stack
        Node node = stack.pop();

        if(!node.isVisited()) {
            node.setVisited(true);
            // save visited order in this global variable
//            this.visitedHistory += node.toString() + "\n";
            // get child list of the current node
            List<Node> unvisitedNodeList = node.getChild();
            // reverse child list in order to visit the first child and not the last one
            Collections.reverse(unvisitedNodeList);

            // push each node into the stack
            for (Node unvisitedNode : unvisitedNodeList) {
                stack.push(unvisitedNode);
            }
        }
        // recursive call
        recursiveVisit();
    }
}
