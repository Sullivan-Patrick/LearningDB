import com.mycompany.app.common.types.Type;

/**
 * A PlanNode represents a node in the plan tree which will eventually be translated into an
 * execution node in the execution tree. Data cannot actually flow through a plan tree (i.e. there
 * is no next() method on the nodes), instead each PlanNode has a translateToExecutionNode method
 * which will use information from the PlanNode to build a corresponding execution node
 */
public interface PlanNode<InputType extends Type, OutputType extends Type> {

}
