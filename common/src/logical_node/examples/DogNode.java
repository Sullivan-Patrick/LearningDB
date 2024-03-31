package logical_node.examples;

import logical_node.Node;
import logical_node.Visitor;

import java.util.List;

public class DogNode extends AnimalNode {
    @Override
    public <R, C> R accept(AnimalVisitor<R, C> visitor, C context) {
        return visitor.visitDogNode(this, context);
    }

    public DogNode(String id, List<AnimalNode> children) {
        this.children = children;
        this.id = id;
    }

    @Override
    public String toString() {
        return "logical_node.examples.DogNode{" +
                "id='" + id + '\'' +
                '}';
    }

    String id;
}
