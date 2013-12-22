package smallc.parser.ast;

public class Pi extends Exp2 {

	public Pi(Exp exp) {
		this.exp = exp;
	}
	
	public String toString() {
        return " " + exp + "++ ";
    }
	
	public void codegen(Shared shared) {
		if(exp instanceof Exp5) {
			Exp5 expl = (Exp5)exp;
			String lname = expl.lvaluegen(shared);
			
			shared.println("%" + (++shared.base) + " = load i32* " + lname + ", align 4");
			++shared.base;
			shared.println("%" + shared.base + " = add nsw i32 %" + (shared.base - 1) + ", 1");
			shared.lastRet = shared.base;
			
			shared.println("store i32 %" + shared.base + ", i32* " + lname + ", align 4");
			
		} else {
			System.out.println("LVALUE_ERROR");
		}
	}
}
