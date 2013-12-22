package smallc.parser.ast;

public class Estmt1 extends Estmt {

	Stmt stmt;
	
	public Estmt1(Stmt stmt) {
		this.stmt = stmt;
	}
	
    public String toString() {
        return " else " + stmt ;
    }
    
    public void codegen(Shared shared) {
    	this.stmt.codegen(shared);
    }
}
