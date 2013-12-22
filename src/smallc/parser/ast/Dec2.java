package smallc.parser.ast;

public class Dec2 extends Dec {
	
	Var var;
	Init init;
	
	public Dec2(Var var, Init init) {
		this.var = var;
		this.init = init;
	}
	
    public String toString() {
        return " " + var + " = " + init + " ";
    }

    public void codegen(Shared shared) {
    	this.var.declare(shared, init);
    }
    
    public void createStruct(Shared shared, String name) {
    	// init ignored, sorry
    	String subname = this.var.toString().trim();
    	
    	shared.addStructSubname(name, subname);
    }
    public void declareAsStruct(Shared shared, String name) {
    	// init ignored, sorry
    	Var2 newarr = new Var2(var, shared.queryStructSize(name));
    	newarr.declare(shared, null);
    	shared.declareAsStruct(this.var.toString().trim(), name);
    }
}
