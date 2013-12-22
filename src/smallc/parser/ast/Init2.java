package smallc.parser.ast;

import java.util.LinkedList;

public class Init2 extends Init {

	Args _args;
	
	public Init2(Args _args) {
		this._args = _args;
	}
	
    public String toString() {
        return "{" + _args + "}";
    }
    
    public String initToString() {
        return "[" + this._args.initToString() + "]";
    }
    
    public LinkedList<Integer> initArgs() {
    	return this._args.initArgs();
    }
}
