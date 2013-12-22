package smallc.parser.ast;

public abstract class Paras {

	public abstract void codegen_noninit(Shared shared);
	public abstract void codegen_init(Shared shared);
}
