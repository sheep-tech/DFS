package fontys.fhict.nl.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {
    Node buildFixedTreeSample() {
        Node tree = new Node('a');

        Node s = new Node('s');
        Node g = new Node('g');
        Node c = new Node('c');
        Node b = new Node('b');

        s.addChild(g);
        s.addChild(c);

        tree.addChild(s);
        tree.addChild(b);

        return tree;
    }

    @Test
    void DFSVisitTest() {
        Node treeGraph = buildFixedTreeSample();
        DFS dfs = new DFS();

        String visitOrder = dfs.visit(treeGraph);
        String expectedVisitOrder = "a\ns\ng\nc\nb\n";

        System.out.println("Expected order: \n" + expectedVisitOrder + "\n");
        System.out.println("Actual order: \n" + visitOrder + "\n");

        assertEquals(visitOrder, expectedVisitOrder);
    }

    // DFS using arrayList
    @Test
    void DFSArrayListListVisitPerformanceTest() {
        NodeSampleGenerator sampleGenerator = new NodeSampleGenerator();

        Node branch = sampleGenerator.buildDynamicTreeSample(5);
        Node tree = new Node('A');
        int treeSize = 900;
        for (int i = 0; i < treeSize; i++) {
            tree.addChild(branch);
        }
        DFS dfs = new DFS();

        long start = System.currentTimeMillis();
        String visitOrder = dfs.visit(tree);
        long end = System.currentTimeMillis();

        long executionTime = end - start;

        System.out.println("Result: \n" + visitOrder);
        System.out.println(sampleGenerator.getLabelIndex()*treeSize);
        System.out.println("Execution time: " + executionTime + "ms");

    }
}