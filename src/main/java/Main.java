import fontys.fhict.nl.domain.DFS;
import fontys.fhict.nl.domain.Node;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        Node tree = new Node("a");

        Node s = new Node("s");
        Node g = new Node("g");
        Node c = new Node("c");
        Node b = new Node("b");

        s.addChild(g);
        s.addChild(c);

        tree.addChild(s);
        tree.addChild(b);
        System.out.println(dfs.visit(tree));
    }
}
