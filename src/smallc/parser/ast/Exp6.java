package smallc.parser.ast;

import smallc.parser.Symbol;

public class Exp6 extends ExpL {

	Exp exp;
	Symbol id;
	
	public Exp6(Exp exp, Symbol id) {
		this.exp = exp;
		this.id = id;
	}
	
    public String toString() {
        return " " + exp + "." + id + " ";
    }
    
    public void codegen(Shared shared) {
		String name = this.exp.toString().trim();
		int index = shared.querySubname(shared.whichStruct(name) + id.toString().trim());
		
		new Exp5(Symbol.symbol(name), new Arrs1(new Exp7(index), new Arrs2())).codegen(shared);
	}
    
    public String lvaluegen(Shared shared) {
    	String name = this.exp.toString().trim();
		int index = shared.querySubname(shared.whichStruct(name) + id.toString().trim());
		
		return (new Exp5(Symbol.symbol(name), new Arrs1(new Exp7(index), new Arrs2())).lvaluegen(shared));
    }
}
