package smallc.parser.ast;

public class Bn extends Exp2 {

	public Bn(Exp exp) {
		this.exp = exp;
	}
	
    public String toString() {
        return " " + " ~ " + exp + " ";
    }
    
    public void codegen(Shared shared) {
		this.exp.codegen(shared);
		
		int ret1 = shared.lastRet;
		
		shared.base += 1;
		int newb = shared.base;
		
		shared.println("%" + newb + " = xor i32 %" + ret1 + ", -1");
		shared.lastRet = newb;
	}
}
