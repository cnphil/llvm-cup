package smallc.parser.ast;

public class Defs1 extends Defs {

	
	Def def;
	Defs defs;
	
	public Defs1(Def def, Defs defs) {
		this.def = def;
		this.defs = defs;
	}
	
    public String toString() {
        return " " + def + defs + " ";
    }
    
    public void codegen(Shared shared) {
    	if(this.def != null) this.def.codegen(shared);
    	if(this.defs != null) this.defs.codegen(shared);
    }
    
    public void createStruct(Shared shared, String name) {
    	this.def.createStruct(shared, name);
    	this.defs.createStruct(shared, name);
    }
    
}
