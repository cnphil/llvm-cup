package smallc.parser.ast;

import smallc.parser.Symbol;
public class Var1 extends Var {

	Symbol id;
	
	public Var1(Symbol id) {
		this.id = id;
	}
	
	public String toString() {
        return "" + id + "";
    }
	
	public void declare(Shared shared, Init init) {
		//should add self to shared
		
		
		//shared.isArray.put(this.id.toString(), false);
		if(shared.isGlobal) {
			shared.print("@");
			
			String initV = "0";
			if(init != null) initV = init.initToString();
			
			shared.println("" + this.id + "= global i32 " + initV+ ", align 4");
		} else {
			shared.print("%");
			shared.println("" + this.id + " = alloca i32, align 4");
			
			if(init != null) shared.println("store i32 " + init.initToString() + " i32* %" + this.id + ", align 4");
			
			shared.addLocal(this.id.toString());
		}
		
	}
}
