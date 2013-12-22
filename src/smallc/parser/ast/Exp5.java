package smallc.parser.ast;

import smallc.parser.Symbol;

public class Exp5 extends ExpL {

	Symbol id;
	Arrs arrs;
	
	public Exp5(Symbol id, Arrs arrs) {
		this.id = id;
		this.arrs = arrs;
	}
	
    public String toString() {
        return "" + id + arrs + "";
    }
    
    public void codegen(Shared shared) {
		
    	String myid = this.id.toString().trim();
    	String idname = "";
    	if(shared.queryLocal((this.id.toString()))) idname = "%"; else idname = "@";
    	idname += this.id;
    	
    	if(shared.isArray(myid)) {
    		int size = shared.aSize(myid);
    		
    		int breg = this.arrs.getValue(shared);
    		shared.base += 1;
	    	int bbreg = shared.base;
	    	
	    	shared.println("%" + bbreg + " = sext i32 %" + breg + " to i64");
    		
	    	shared.base += 1;
	    	int bbbreg = shared.base;
	    	shared.println("%" + bbbreg + " = getelementptr inbounds [" + size + " x i32]* " + idname + ", i32 0, i64 %" + bbreg + "");
    		
    		shared.base += 1;
	    	int newb = shared.base;
	    	shared.println("%" + newb + " = load i32* %" + bbbreg + ", align 4");
	    	
	    	shared.lastRet = newb;
    		
    		
    		
    	} else {
	    	shared.base += 1;
	    	int newb = shared.base;
	    	
	    	
	    	
	    	shared.println("%" + newb + " = load i32* " + idname + ", align 4");
	    	
	    	shared.lastRet = newb;
    	}
	}
    
    public String lvaluegen(Shared shared) {
    	
    	String myid = this.id.toString().trim();
    	
    	if(shared.isArray(myid)) {
    		int size = shared.aSize(myid);
    		String idname = "";
	    	if(shared.queryLocal((this.id.toString()))) idname = "%"; else idname = "@";
	    	idname += myid;
	    	
	    	int breg = this.arrs.getValue(shared);
	    	
	    	shared.base += 1;
	    	int bbreg = shared.base;
	    	
	    	shared.println("%" + bbreg + " = sext i32 %" + breg + " to i64");
	    	
	    	shared.base += 1;
	    	int bbbreg = shared.base;
	    	
    		shared.println("%" + bbbreg + " = getelementptr inbounds [" + size + " x i32]* " + idname + ", i32 0, i64 %" + bbreg + "");
    	
    		return "%" + bbbreg;
    	} else {
	    	String idname = "";
	    	if(shared.queryLocal((this.id.toString()))) idname = "%"; else idname = "@";
	    	idname += myid;
	    	
	    	return idname;
    	}
    }
}
