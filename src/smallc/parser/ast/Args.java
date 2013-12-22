package smallc.parser.ast;

import java.util.LinkedList;
import java.util.List;

public abstract class Args {

	public abstract LinkedList<Integer> codegen(Shared shared);
	
	public abstract String masterTake(Shared shared);
	
	public abstract String initToString();
	
	public abstract LinkedList<Integer> initArgs();
}
