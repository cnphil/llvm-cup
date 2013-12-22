package smallc.parser.ast;

public class Exp7 extends Exp {

	int num;
	
	public Exp7(int num) {
		this.num = num;
	}
	
    public String toString() {
        return " " + num + " ";
    }
    
    public void codegen(Shared shared) {
    	shared.base += 1;
    	int newb = shared.base;
    	
    	shared.println("%" + newb + " = add nsw i32 0, " + num);
    	
    	shared.lastRet = shared.base;
	}
}
