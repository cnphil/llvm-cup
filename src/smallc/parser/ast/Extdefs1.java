package smallc.parser.ast;

public class Extdefs1 extends Extdefs {
	Extdef extdef;
	Extdefs extdefs;
	
	
	public Extdefs1(Extdef extdef, Extdefs extdefs) {
		
		this.extdef = extdef;
		this.extdefs = extdefs;
	}
	
    public String toString() {
        return "" + extdef + " " + extdefs;
    }
    
    public void codegen(Shared shared) {
    	
    	if(this.extdef != null) this.extdef.codegen(shared);
    	if(this.extdefs != null) this.extdefs.codegen(shared);
    }
	
}
