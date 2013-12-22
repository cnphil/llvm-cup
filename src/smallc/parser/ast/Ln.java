package smallc.parser.ast;

public class Ln extends Exp2 {

	public Ln(Exp exp) {
		this.exp = exp;
	}
	
	public String toString() {
        return " ! " + exp + " ";
    }
	
	public void codegen(Shared shared) {
		this.exp.codegen(shared);
		
		/*
		 * %14 = icmp ne i32 %13, 0
  %15 = xor i1 %14, true
  %16 = zext i1 %15 to i32
		 */
		int top = ++shared.base;
		shared.println("%" + top + " = icmp ne i32 %" + (top - 1) + ", 0");
		
		top = ++shared.base;
		shared.println("%" + top + " = xor i1 %" + (top - 1) + ", true");
		
		top = ++shared.base;
		shared.println("%" + top + " = zext i1 %" + (top - 1) + " to i32");
		
		shared.lastRet = top;
		
	}
}
