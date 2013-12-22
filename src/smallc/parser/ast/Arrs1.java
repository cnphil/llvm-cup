package smallc.parser.ast;

public class Arrs1 extends Arrs {

	Exp exp;
	Arrs arrs;
	
	public Arrs1(Exp exp, Arrs arrs) {
		this.exp = exp;
		this.arrs = arrs;
	}
	
    public String toString() {
        return " " + "[" + exp + "]" + arrs + " ";
    }
    
    public int getValue(Shared shared) {
    	this.exp.codegen(shared);
    	int newret = shared.lastRet;
    	
    	return newret;
    }
}
