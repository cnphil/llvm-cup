package smallc.parser.ast;

public class Decs1 extends Decs {
	
	Dec dec;
	Decs decs;
	
	public Decs1(Dec dec, Decs decs) {
		this.dec = dec;
		this.decs = decs;
	}
	
    public String toString() {
        return " " + dec + "," + decs + " ";
    }
    
    public void codegen(Shared shared) {
    	if(this.dec != null) this.dec.codegen(shared);
    	if(this.decs != null) this.decs.codegen(shared);
    }
    
    public void createStruct(Shared shared, String name) {
    	this.dec.createStruct(shared, name);
    	this.decs.createStruct(shared, name);
    }
    
    public void declareAsStruct(Shared shared, String name) {
    	this.dec.declareAsStruct(shared, name);
    	this.decs.declareAsStruct(shared, name);
    }

}
