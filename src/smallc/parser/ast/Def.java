package smallc.parser.ast;

public class Def {

	Spec spec;
	Decs decs;
	
	public Def(Spec spec, Decs decs) {
		this.spec = spec;
		this.decs = decs;
	}
	
    public String toString() {
        return " " + spec + decs + ";";
    }
    
    public void codegen(Shared shared) {
    	if(this.spec instanceof Spec1) {
    		this.decs.codegen(shared);
    	} else {
    		String name = ((Spec2)this.spec).structName(shared);
    		this.decs.declareAsStruct(shared, name);
    	}
    }
    
    public void createStruct(Shared shared, String name) {
    	this.decs.createStruct(shared, name);
    }
    
}
