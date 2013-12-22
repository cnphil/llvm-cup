package smallc.parser.ast;

public class Init1 extends Init {
	
	Exp exp;
	
	public Init1(Exp exp) {
		this.exp = exp;
	}

    public String toString() {
        return " " + exp + " ";
    }
    
    public String initToString() {
    	return exp.toString().trim();
    }
}
