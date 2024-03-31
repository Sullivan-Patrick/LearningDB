package logical_node;

// Visitor interface needs to be aware of all implementations of Node to have visit{x}Node methods declared for each.
public abstract class Visitor<R, C> {

  abstract R visitPlan(Node node, C context);

  // Example visit node function. See examples directory for complete example of implemented visitor pattern.
//    R visitDogNode(DogNode node, C context) {
//        return visitPlan(node, context);
//    }

}