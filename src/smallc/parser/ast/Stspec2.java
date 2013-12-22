package smallc.parser.ast;

import smallc.parser.Symbol;

public class Stspec2 extends Stspec {
	
	Symbol id;
	
	public Stspec2(Symbol id) {
		this.id = id;
	}
	
	public String toString() {
        return " struct " + id + " ";
    }

/*	public Stspec2(java_cup.runtime.Symbol symbol) {
		// TODO Auto-generated constructor stub
	}
*/
	public String structName(Shared shared) {
		return this.id.toString().trim();
	}
	
}

