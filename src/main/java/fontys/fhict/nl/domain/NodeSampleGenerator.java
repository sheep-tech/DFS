package fontys.fhict.nl.domain;

import java.util.Random;

public class NodeSampleGenerator {
    // These var are used for building sample trees
    private Random rand;
    private int labelIndex;

    public NodeSampleGenerator() {
        this.rand = new Random();
        this.labelIndex = 0;
    }

    Node buildDynamicTreeSample(int level) {
        this.labelIndex = 0;
        Node root = new Node(generateLabel(labelIndex++));

        buildDynamicTreeSampleRecursive(root, level);

        return root;
    }

    void buildDynamicTreeSampleRecursive(Node node, int treeLevel) {
        if(treeLevel == 0)
            return;
        else {
//            System.out.println("Level: " + treeLevel + " label: " + node.toString());
            // create children
            int numOfchildren = rand.nextInt(5) + 2;
            for (int j = 0; j < numOfchildren; j++) {
                Node child = new Node(generateLabel(labelIndex++));
                node.addChild(child);

                // recursive call
                buildDynamicTreeSampleRecursive(child, --treeLevel);
                treeLevel++;
            }
        }
    }

    public int getLabelIndex() {
        return labelIndex;
    }

    public char generateLabel(int number) {
        return (char)((number%54) + 65);
    }

}
