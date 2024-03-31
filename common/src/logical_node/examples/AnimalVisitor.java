package logical_node.examples;

// Visitor interface needs to be aware of all implementations of Node to have visit{x}Node methods declared for each.
public abstract class AnimalVisitor<R, C> {

    abstract R visitPlan(AnimalNode node, C context);

    R visitDogNode(DogNode node, C context) {
        return visitPlan(node, context);
    }

    R visitCatNode(CatNode node, C context) {
        return visitPlan(node, context);
    }
}