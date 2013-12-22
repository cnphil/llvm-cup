package smallc.parser.ast;

public class Para {

	Spec spec;
	Var var;
	
	public Para(Spec spec, Var var) {
		this.spec = spec;
		this.var = var;
	}
	
	public String toString() {
        return " " + spec + "" + var + " ";
    }
	
	public void codegen_noninit(Shared shared) {
		shared.print("i32 %" + var+"_HXJ");
		
		shared.addLocal(this.var.toString().trim());
	}
	
	public void codegen_init(Shared shared) {
		shared.println("%" + var + " = alloca i32, align 4");
		shared.println("store i32 %" + var+"_HXJ" + ", i32* %" + var + ", align 4");
		
	}
}
