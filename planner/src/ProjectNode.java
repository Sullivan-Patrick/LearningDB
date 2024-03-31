import com.mycompany.app.common.types.Type;

import java.util.List;

/**
 * Think about how this works E2E: How do we
 */
public class ProjectNode<InputType extends Type, OutputType extends Type> implements
    PlanNode<InputType, OutputType> {

  List<InputType> getSources() {

  }
}

