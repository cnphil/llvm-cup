package smallc.parser.ast;

public class Stmt1 extends Stmt {

	Exp exp;
	
	public Stmt1(Exp exp) {
		this.exp = exp;
	}
	
	public String toString() {
        return " " + exp + "; ";
    }
	
	public void codegen(Shared shared) {
		this.exp.codegen(shared);
		shared.println("");
	}
}
