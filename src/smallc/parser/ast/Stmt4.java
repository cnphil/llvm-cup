package smallc.parser.ast;

public class Stmt4 extends Stmt {
	
	Exp exp;
	Stmt stmt;
	Estmt estmt;
	
	public Stmt4(Exp exp, Stmt stmt, Estmt estmt) {
		this.exp = exp;
		this.stmt = stmt;
		this.estmt = estmt;
	}
	
	public String toString() {
        return " if(" + exp + ")" + stmt + estmt + " ";
    }
	
	public void codegen(Shared shared) {
		this.exp.codegen(shared);
		int expret = shared.base;
		
		int top = ++shared.base;
		shared.println("%" + top + " = icmp ne i32 %" + expret + ", 0");
		
		String marker1 = shared.newMarker(), marker2 = shared.newMarker(), marker3 = shared.newMarker();
		
		top = ++shared.base;
		shared.println("br i1 %" + (top - 1) + ", label %" + marker1 + ", label %" + marker2);
		
		shared.println("\n; <label>:" + top);
		shared.markerReplace(marker1, top);
		
		this.stmt.codegen(shared);
		
		top = ++shared.base;
		shared.println("br label %" + marker3);
		
		shared.println("\n; <label>:" + top);
		shared.markerReplace(marker2, top);
		
		this.estmt.codegen(shared);
		
		top = ++shared.base;
		shared.println("br label %" + marker3);
		
		shared.println("\n; <label>:" + top);
		shared.markerReplace(marker3, top);
		
		//top = ++shared.base;
		//shared.println("%" + top + " = add nsw i32 0, 0");
		
	}

}
