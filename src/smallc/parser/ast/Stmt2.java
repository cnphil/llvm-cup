package smallc.parser.ast;

public class Stmt2 extends Stmt {
	
	Stmtblock stmtblock;
	
	public Stmt2(Stmtblock stmtblock) {
		this.stmtblock = stmtblock;
	}
	
	public String toString() {
        return " " + stmtblock + " ";
    }
	
	public void codegen(Shared shared) {
		this.stmtblock.codegen(shared);
	}

}
