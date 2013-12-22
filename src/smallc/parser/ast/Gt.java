package smallc.parser.ast;

public class Gt extends Exp1 {

	public Gt(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
    public String toString() {
        return " " + exp1 + ">" + exp2 + " ";
    }
    
    public void codegen(Shared shared) {
		this.exp1.codegen(shared);
		
		int ret1 = shared.lastRet;
		
		this.exp2.codegen(shared);
		
		int ret2 = shared.lastRet;
		
		shared.base += 1;
		int newb = shared.base;
		
		shared.println("%" + newb + " = icmp sgt i32 %" + ret1 + ", %" + ret2);
		
		newb = ++shared.base;
		
		shared.println("%" + newb + " = zext i1 %" + (newb - 1) + " to i32");
		
		shared.lastRet = newb;
	}
}
