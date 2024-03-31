package logical_node.examples;

import logical_node.Node;
import logical_node.Visitor;

public class PrettyPrintVisitor extends AnimalVisitor<Void, String> {

    @Override
    Void visitPlan(AnimalNode node, String context) {
        node.accept(this, context);
        return null;
    }

    @Override
    Void visitDogNode(DogNode node, String context) {
        // Print it's a good boy
        System.out.println(context + node.toString());
        // Enter children
        for (AnimalNode n : node.children) {
            visitPlan(n, context + "  ");
        }
        return null;
    }

    @Override
    Void visitCatNode(CatNode node, String context) {
        System.out.println(context + node.toString());
        return null;
    }
}
