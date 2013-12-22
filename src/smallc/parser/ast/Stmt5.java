package smallc.parser.ast;

public class Stmt5 extends Stmt {
	
	Exp exp1,exp2,exp3;
	Stmt stmt;
	
	public Stmt5(Exp exp1, Exp exp2, Exp exp3, Stmt stmt) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.exp3 = exp3;
		this.stmt = stmt;
	}
	
	public String toString() {
        return " for(" + exp1 + ";" + exp2 + ";" + exp3 + ")" +stmt + " " ;
    }
	
	public void codegen(Shared shared) {
		this.exp1.codegen(shared);
		
		String marker2 = shared.newMarker(), marker3 = shared.newMarker(), marker4 = shared.newMarker();
		
		shared.base++;
		shared.println("br label %" + marker2);
		
		// marker1 here
		
		String marker1 = "" + shared.base;
		shared.println("; <label>:" + shared.base);
		
		this.exp3.codegen(shared);
		shared.base++;
		shared.println("br label %" + marker2);
		
		// marker2 here
		shared.println("; <label>:" + shared.base);
		shared.markerReplace(marker2, shared.base);
		
		this.exp2.codegen(shared);
		int expret = shared.lastRet;
		int top = ++shared.base;
		shared.println("%" + top + " = icmp ne i32 %" + expret + ", 0");
		
		top = ++shared.base;
		shared.println("br i1 %" + (top - 1) + ", label %" + marker3 + ", label %" + marker4);
		
		// marker3 here <- begin of stmt
		shared.println("; <label>:" + shared.base);
		shared.markerReplace(marker3, shared.base);
		this.stmt.codegen(shared);
		++shared.base;
		shared.println("br label %" + marker1);
		// marker4 here <- end of stmt
		shared.println("; <label>:" + shared.base);
		shared.markerReplace(marker4, shared.base);
		
	}

}
