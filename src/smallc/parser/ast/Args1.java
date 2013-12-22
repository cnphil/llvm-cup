package smallc.parser.ast;

import java.util.LinkedList;
import java.util.List;

public class Args1 extends Args {

	Exp exp;
	Args _args;
	
	public Args1(Exp exp, Args _args) {
		this.exp = exp;
		this._args = _args;
	}
	
    public String toString() {
        return " " + exp + "," + _args + " ";
    }
    
    public String initToString() {
        return " i32" + exp + "," + this._args.initToString();
    }
    
    public LinkedList<Integer> codegen(Shared shared)
    {
		this.exp.codegen(shared);
		int ret1 = shared.lastRet;
		
		LinkedList<Integer> ret = this._args.codegen(shared);
		
		ret.push(ret1);
		return ret;
    	
    }
    
	public String masterTake(Shared shared) {return null;}
	
	public LinkedList<Integer> initArgs() {
		LinkedList<Integer> lli = this._args.initArgs();
		
		lli.push(Integer.parseInt(this.exp.toString().trim()));
		
		return lli;
	}
}
