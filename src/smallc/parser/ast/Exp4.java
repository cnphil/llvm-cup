package smallc.parser.ast;

import java.util.*;

import smallc.parser.Symbol;

public class Exp4 extends Exp {

	Symbol id;
	Args _args;
	
	public Exp4(Symbol id,Args _args) {
		this.id = id;
		this._args = _args;
	}
	
    public String toString() {
        return " " + id + "(" + _args + ")";
    }
    
    public void codegen(Shared shared) {
    	if(id.toString().equals("read")) {
    		String addr = this._args.masterTake(shared);
    		
    		shared.base += 1;
        	int newb = shared.base;
    		shared.println("%" + newb + " = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.str, i32 0, i32 0), i32* " + addr + ")");
    		
    		shared.lastRet = newb;
    		return;
    	}
    	
    	LinkedList<Integer> retArgs = this._args.codegen(shared); // new ArrayList<Integer>();
    	
    	shared.base += 1;
    	int newb = shared.base;
    	shared.print("%" + newb + " = call i32 @" + id + "(");
    	while (retArgs.size() > 0) {
    		int cur = retArgs.pop();
    		shared.print("i32 %" + cur);
    		if(retArgs.size() > 0) shared.print(", ");
    	}
    	shared.println(")");
    	shared.lastRet = newb;
	}
}
