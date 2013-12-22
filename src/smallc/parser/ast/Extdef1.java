package smallc.parser.ast;

public class Extdef1 extends Extdef {

	Spec spec;
	Extvars extvars;
	
	public Extdef1(Spec spec, Extvars extvars) {
		this.spec = spec;
		this.extvars = extvars;
	}
	
    public String toString() {
        return "" + spec + extvars + ";";
    }
    
    public void codegen(Shared shared) {
    	if(this.spec instanceof Spec1) {
    		this.extvars.codegen(shared);
    	} else {
    		String name = ((Spec2)this.spec).structName(shared);
    		this.extvars.declareAsStruct(shared, name);
    	}
    }
}
