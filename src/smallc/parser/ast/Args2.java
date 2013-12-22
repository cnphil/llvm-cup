package smallc.parser.ast;

import java.util.*;

public class Args2 extends Args {

	Exp exp;
	
	public Args2(Exp exp) {
		this.exp = exp;
	}
	
    public String toString() {
        return " " + exp + " ";
    }
    
    public String initToString() {
        return "i32 " + exp + "";
    }
    
    public LinkedList<Integer> initArgs() {
    	LinkedList<Integer> lli = new LinkedList<Integer>();
    	lli.push(Integer.parseInt(this.exp.toString().trim()));
    	
    	return lli;
	}
    
    public LinkedList<Integer> codegen(Shared shared)
    {
    	LinkedList<Integer> ret = new LinkedList<Integer>();
    	exp.codegen(shared);
    	
    	ret.push(shared.lastRet);
    	return ret;
    }
    
	public String masterTake(Shared shared) {
		if(this.exp instanceof ExpL) {
			return ((ExpL)this.exp).lvaluegen(shared);
		}
		
		String ret = "";
		
		if(shared.queryLocal(exp.toString().trim())) {
			ret += "%";
		} else {
			ret += "@";
		}
	
		return ret + exp.toString().trim();
	}

}
