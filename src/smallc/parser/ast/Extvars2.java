package smallc.parser.ast;

public class Extvars2 extends Extvars {
	
	Dec dec;
	Extvars extvars;
	
	public Extvars2(Dec dec, Extvars extvars) {
		this.dec = dec;
		this.extvars = extvars;
	}
	
    public String toString() {
        return " " + dec + "," + extvars + " ";
    }
    
    public void codegen(Shared shared) {
    	this.dec.codegen(shared);
    	
    	this.extvars.codegen(shared);
    }
    
    public void declareAsStruct(Shared shared, String name) {
    	this.dec.declareAsStruct(shared, name);
    	
    	this.extvars.declareAsStruct(shared, name);
    }

}
