package smallc.parser.ast;

public class Paras1 extends Paras {
	
	Para para;
	Paras paras;
	
	public Paras1(Para para, Paras paras) {
		this.para = para;
		this.paras = paras;
	}
	
	public String toString() {
        return " " + para + "," + paras + " ";
    }
	
	public void codegen_noninit(Shared shared) {
		this.para.codegen_noninit(shared);
		if(this.paras == null || (this.paras instanceof Paras3)) {
			return;
		} else {
			shared.print(", ");
			this.paras.codegen_noninit(shared);
		}
	}
	
	public void codegen_init(Shared shared) {
		this.para.codegen_init(shared);
		if(this.paras == null || (this.paras instanceof Paras3)) {
			return;
		} else {
			shared.print("\n");
			this.paras.codegen_init(shared);
		}
	}
	

}
