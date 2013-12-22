package smallc.parser.ast;

import java.util.LinkedList;
import smallc.parser.Symbol;

public class Var2 extends Var {

	Var var;
	int num;

	public Var2(Var var, int num) {
		this.var = var;
		this.num = num;
	}
	
	public String toString() {
        return " " + var + "[" + num + "]";
    }
	
	public void declare(Shared shared, Init init) {
		String myid = this.var.toString().trim();
		shared.addArray(myid, num);
		
		if(shared.isGlobal) {
			String initV = "zeroinitializer";
			if(init != null) initV = init.initToString();
			
			shared.print("@");
			shared.println("" + myid + "= global [" + num + " x i32] " + initV + ", align 4");
		} else {
			shared.addLocal(myid.toString());
			shared.print("%");
			shared.println("" + myid + " = alloca [" + num + " x i32], align 4");
			
			if(init != null) {
				LinkedList<Integer> lli = ((Init2)init).initArgs();
				int iter = 0;
				while(lli.size() > 0) {
					Exp7 rexp = new Exp7(lli.pop());
					Exp7 lnum = new Exp7(iter);
					Arrs1 larr = new Arrs1(lnum, new Arrs2());
					Exp5 lexp = new Exp5(Symbol.symbol(myid), larr);
					As ass = new As(lexp, rexp);
					
					ass.codegen(shared);
					
					iter++;
				}
			}
		}
	}
}
