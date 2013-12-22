package smallc.parser.ast;

public abstract class Defs {

	
	public abstract void codegen(Shared shared);
	
	public abstract void createStruct(Shared shared, String name);

}
