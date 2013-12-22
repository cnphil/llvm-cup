package smallc.parser.ast;

public class Exp3 extends Exp {

	Exp exp;
	
	public Exp3(Exp exp) {
		this.exp = exp;
	}
	
    public String toString() {
        return "(" + exp + ")";
    }
    
    public void codegen(Shared shared) {
		this.exp.codegen(shared);
	}
}
