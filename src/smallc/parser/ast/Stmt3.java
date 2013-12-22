package smallc.parser.ast;

public class Stmt3 extends Stmt {
	
	Exp exp;
	
	public Stmt3(Exp exp) {
		this.exp = exp;
	}
	
	public String toString() {
        return " return " + exp + "; ";
    }

	public void codegen(Shared shared) {
		this.exp.codegen(shared);
		
		int ret = shared.lastRet;
		
		shared.base++;
		
		shared.println("ret i32 %" + ret);
	}
}
