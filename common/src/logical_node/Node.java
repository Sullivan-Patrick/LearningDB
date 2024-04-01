package logical_node;

import java.util.List;

public abstract class Node {

  public <R, C> R accept(Visitor<R, C> visitor, C context) {
    return visitor.visitPlan(this, context);
  }

  List<Node> children;
}
