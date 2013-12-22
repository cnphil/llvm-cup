package smallc.parser.ast;

public class Spec2 extends Spec {
	
	Stspec stspec;
	
	public Spec2( Stspec stspec) {
		this.stspec = stspec;
	}

	public String toString() {
        return " " + stspec + " ";
    }
	
	public String structName(Shared shared) {
		return this.stspec.structName(shared);
	}
}
