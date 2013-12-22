package smallc.parser.ast;

public class Decs2 extends Decs {

	Dec dec;
	
	public Decs2(Dec dec) {
		this.dec = dec;
	}
	
    public String toString() {
        return " " + dec + " ";
    }
    
    public void codegen(Shared shared) {
    	if(this.dec != null) this.dec.codegen(shared);
    }
    
    public void createStruct(Shared shared, String name) {
    	this.dec.createStruct(shared, name);
    }
    
    public void declareAsStruct(Shared shared, String name) {
    	this.dec.declareAsStruct(shared, name);
    }
}
