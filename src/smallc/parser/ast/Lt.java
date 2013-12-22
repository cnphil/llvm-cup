package smallc.parser.ast;

public class Lt extends Exp1 {

	public Lt(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	public String toString() {
        return " " + exp1 + "<" + exp2 + " ";
    }
	
	public void codegen(Shared shared) {
		/*
		 * %15 = icmp slt i32 %13, %14
  			%16 = zext i1 %15 to i32
		 */
		
		this.exp1.codegen(shared);
		int regA = shared.lastRet;
		
		this.exp2.codegen(shared);
		int regB = shared.lastRet;
		
		++shared.base;
		shared.println("%" + shared.base + " = icmp slt i32 %" + regA + ", %" + regB);
		
		++shared.base;
		shared.println("%" + shared.base + " = zext i1 %" + (shared.base - 1) + " to i32");
		
		shared.lastRet = shared.base;
		
	}
}
