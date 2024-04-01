package logical_node.examples;

public class CatNode extends AnimalNode {

  @Override
  public <R, C> R accept(AnimalVisitor<R, C> visitor, C context) {
    return visitor.visitCatNode(this, context);
  }

  public CatNode(String id) {
    this.children = null;
    this.id = id;
  }

  @Override
  public String toString() {
    return "logical_node.examples.CatNode{" +
        "id='" + id + '\'' +
        '}';
  }

  String id;
}
