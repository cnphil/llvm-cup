package smallc.parser.ast;
import smallc.parser.Symbol;

public class Dec1 extends Dec {
	
	Var var;
	
	public Dec1(Var var) {
		this.var = var;
	}

    public String toString() {
        return " " + var + " ";
    }
    
    public void codegen(Shared shared) {
    	this.var.declare(shared, null);
    }
    
    public void createStruct(Shared shared, String name) {
    	String subname = this.var.toString().trim();
    	
    	shared.addStructSubname(name, subname);
    }
    
    public void declareAsStruct(Shared shared, String name) {
    	Var2 newarr = new Var2(var, shared.queryStructSize(name));
    	newarr.declare(shared, null);
    	shared.declareAsStruct(this.var.toString().trim(), name);
    }
}
