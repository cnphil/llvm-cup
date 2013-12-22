package smallc.parser.ast;

import smallc.parser.Symbol;

public class Func {
	
	Symbol id;
	Paras paras;
	
	public Func(Symbol id, Paras paras) {
		this.id = id;
		this.paras = paras;
	}
	
    public String toString() {
        return " " + id + "(" + paras + ")";
    }
    
    public void codegen(Shared shared) {
    	shared.print("define i32 @" + id + "(");
    	this.paras.codegen_noninit(shared);
    	shared.print(") nounwind ssp uwtable {\n");
    	this.paras.codegen_init(shared);
    	
    }

}
