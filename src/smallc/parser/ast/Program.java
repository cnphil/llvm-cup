package smallc.parser.ast;

public class Program {

	Extdefs extdefs;
	
	public Program(Extdefs extdefs) {
		this.extdefs = extdefs;
	}
	
	public String toString() {
        return " " + extdefs + " ";
    }
	
	public void codegen(Shared shared) {
		shared.println("; read: call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.str, i32 0, i32 0), i32* pointer)"
+ "\n @.str = private unnamed_addr constant [3 x i8] c\"%d\00\", align 1"
+ "\n @.str1 = private unnamed_addr constant [4 x i8] c\"%d\n\00\", align 1"
+ "\n declare i32 @scanf(i8*, ...)"
+ "\n declare i32 @printf(i8*, ...)"
+ "\n define i32 @write(i32 %foo) nounwind ssp uwtable {"
+ "\n  %1 = alloca i32, align 4"
+ "\n  %2 = alloca i32, align 4"
+ "\n  store i32 %foo, i32* %2, align 4"
+ "\n  %3 = load i32* %2, align 4"
+ "\n  %4 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @.str1, i32 0, i32 0), i32 %3)"
+ "\n  %5 = load i32* %1"
+ "\n  ret i32 %5"
+ "\n }");
		
		this.extdefs.codegen(shared);
	}
}
