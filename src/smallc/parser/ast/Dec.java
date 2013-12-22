package smallc.parser.ast;

public abstract class Dec {

	
	public abstract void codegen(Shared shared);
	
	public abstract void createStruct(Shared shared, String name);
	
	public abstract void declareAsStruct(Shared shared, String name);
}
