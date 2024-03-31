package logical_node.examples;

import java.util.List;

public abstract class AnimalNode {

  public <R, C> R accept(AnimalVisitor<R, C> visitor, C context) {
    return visitor.visitPlan(this, context);
  }

  List<AnimalNode> children;
}
