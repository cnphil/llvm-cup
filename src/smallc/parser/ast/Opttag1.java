package smallc.parser.ast;

import smallc.parser.Symbol;

public class Opttag1 extends Opttag {
	
	Symbol id;
	
	public Opttag1(Symbol id) {
		this.id = id;
	}
	
	public String toString() {
        return " " + id + " ";
    }
	
}
