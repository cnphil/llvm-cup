package smallc.parser.ast;

public class La extends Exp1 {

	public La(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
    public String toString() {
        return " " + exp1 + "&&" + exp2 + " ";
    }
    
    public void codegen(Shared shared) {
		this.exp1.codegen(shared);
		
		int ret1 = shared.lastRet;
		
		this.exp2.codegen(shared);
		
		int ret2 = shared.lastRet;
		
		shared.println("%" + (++shared.base) + " = icmp ne i32 %" + ret1 + ", 0");
		++shared.base;
		shared.println("%" + shared.base + " = zext i1 %" + (shared.base - 1) + " to i32");
		
		int ret11 = shared.base;
		
		shared.println("%" + (++shared.base) + " = icmp ne i32 %" + ret2 + ", 0");
		++shared.base;
		shared.println("%" + shared.base + " = zext i1 %" + (shared.base - 1) + " to i32");
		
		int ret22 = shared.base;
		
		
		shared.base += 1;
		int newb = shared.base;
		shared.println("%" + newb + " = and i32 %" + ret11 + ", %" + ret22);
		shared.lastRet = newb;
	}
}
