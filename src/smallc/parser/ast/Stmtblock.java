package smallc.parser.ast;

// Calling Stmtblock's codegen: print {} first! & should handle base

public class Stmtblock {
	
	Defs defs;
	Stmts stmts;
	
	public Stmtblock(Defs defs, Stmts stmts) {
		this.defs = defs;
		this.stmts = stmts;
	}
	
	public String toString() {
        return " {" + defs + stmts + "} ";
    }
	
	public void codegen(Shared shared) {
		this.defs.codegen(shared);
		this.stmts.codegen(shared);
	}

}
