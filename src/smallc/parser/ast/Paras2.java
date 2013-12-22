package smallc.parser.ast;

public class Paras2 extends Paras {
	
	Para para;
	
	public Paras2(Para para) {
		this.para = para;
	}
	
	public String toString() {
        return " " + para + " ";
    }

	public void codegen_noninit(Shared shared) {
		this.para.codegen_noninit(shared);
	}
	
	public void codegen_init(Shared shared) {
		this.para.codegen_init(shared);
	}
}
