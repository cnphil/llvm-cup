package smallc.parser.ast;

public class Neg extends Exp2 {

	public Neg(Exp exp) {
		this.exp = exp;
	}
	
	public String toString() {
        return "-" + exp + " ";
    }
	
	public void codegen(Shared shared) {
		this.exp.codegen(shared);
		
		int ret1 = shared.lastRet;
		
		shared.base += 1;
		int newb = shared.base;
		
		shared.println("%" + newb + " = sub nsw i32 0, %" + ret1);
		shared.lastRet = newb;
	}
}
