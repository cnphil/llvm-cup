package smallc.parser.ast;

public abstract class Extvars {

	public abstract void codegen(Shared shared);
	
	public abstract void declareAsStruct(Shared shared, String name);
}
