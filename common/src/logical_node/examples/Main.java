package logical_node.examples;

import java.util.ArrayList;
import java.util.List;

public class Main {

  static AnimalNode createDogTree() {
    DogNode dog1 = new DogNode("Leaf doggo", new ArrayList<>());
    CatNode cat1 = new CatNode("Leaf kitty1");
    CatNode cat2 = new CatNode("Leaf kitty2");
    DogNode dog2 = new DogNode("Intermediate doggo", List.of(cat1, dog1));
    DogNode dog3 = new DogNode("Root doggo", List.of(dog2, cat2));

    return dog3;
  }

  public static void main(String[] args) {
    AnimalNode node = createDogTree();

    PrettyPrintVisitor visitor = new PrettyPrintVisitor();

    // Enter plan on unknown node type
    visitor.visitPlan(node, "");
  }
}