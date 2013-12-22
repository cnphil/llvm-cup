package smallc.parser.ast;

public class Stspec1 extends Stspec {

	Opttag opttag;
	Defs defs;
	
	public Stspec1(Opttag opttag, Defs defs) {
		this.opttag = opttag;
		this.defs = defs;
	}
	
	public String toString() {
        return " struct " + opttag + "{" + defs + "}";
    }
	
	public String structName(Shared shared) {
		String name = this.opttag.toString().trim();
		if(name.equals("")) name = shared.newStruct();
		
		this.defs.createStruct(shared, name);
		
		return name;
	}
}
