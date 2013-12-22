package smallc.parser.ast;

public class Stmts1 extends Stmts {

	Stmt stmt;
	Stmts stmts;
	
	public Stmts1(Stmt stmt, Stmts stmts) {
		this.stmt = stmt;
		this.stmts = stmts;
	}
	
	public String toString() {
        return " " + stmt + stmts + " ";
    }
	
	public void codegen(Shared shared) {
		if(this.stmt != null) this.stmt.codegen(shared);
		if(this.stmts != null) this.stmts.codegen(shared);
	}
}
