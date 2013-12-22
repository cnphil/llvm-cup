package smallc.parser.ast;

public class Extdef2 extends Extdef {

	Spec spec;
	Func func;
	Stmtblock stmtblock;
	
	public Extdef2(Spec spec, Func func, Stmtblock stmtblock) {
		
		this.spec = spec;
		this.func = func;
		this.stmtblock = stmtblock;
	}
	
    public String toString() {
        return "" + spec + func + stmtblock;
    }
    
    public void codegen(Shared shared) {
    	this.func.codegen(shared);
    	
    	shared.isGlobal = false;
    	shared.base = 0;
    	this.stmtblock.codegen(shared);
    	shared.isGlobal = true;
    	
    	shared.println("\n ret i32 0\n }"); // { generated in func
    }
}
