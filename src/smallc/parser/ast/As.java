package smallc.parser.ast;

public class As extends Exp1 {
	public As(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
    public String toString() {
        return " " + exp1 + " & " + exp2 + " ";
    }
    
    public void codegen(Shared shared) {
		if(exp1 instanceof ExpL) {
			ExpL expl = (ExpL)exp1;
			String lname = expl.lvaluegen(shared);
			
			
			exp2.codegen(shared);
			
			int rreg = shared.lastRet;
			
			shared.println("store i32 %" + rreg + ", i32* " + lname + ", align 4");
			
		} else {
			System.out.println("LVALUE_ERROR");
		}
	}
}
