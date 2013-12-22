package smallc.parser.ast;

public class Sub extends Exp1 {

	public Sub(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	public String toString() {
        return " " + exp1 + "-" + exp2 + " ";
    }
	
	public void codegen(Shared shared) {
		this.exp1.codegen(shared);
		
		int ret1 = shared.lastRet;
		
		this.exp2.codegen(shared);
		
		int ret2 = shared.lastRet;
		
		shared.base += 1;
		int newb = shared.base;
		
		shared.println("%" + newb + " = sub nsw i32 %" + ret1 + ", %" + ret2);
		shared.lastRet = newb;
	}
}
