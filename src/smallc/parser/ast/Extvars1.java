package smallc.parser.ast;

public class Extvars1 extends Extvars {
	
	Dec dec;
	
	
	public Extvars1(Dec dec) {
		this.dec = dec;
	}

    public String toString() {
        return " " + dec + " ";
    }
    
    public void codegen(Shared shared) {
    	this.dec.codegen(shared);
    }
    
    public void declareAsStruct(Shared shared, String name) {
    	this.dec.declareAsStruct(shared, name);
    }
}
