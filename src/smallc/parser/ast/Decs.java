package smallc.parser.ast;

public abstract class Decs {

	public abstract void codegen(Shared shared);
	
	public abstract void createStruct(Shared shared, String name);
	
	public abstract void declareAsStruct(Shared shared, String name);
}
