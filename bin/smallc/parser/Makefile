all: Parser.java Symbols.java Lexer.java

Parser.java: smallc.grm
	java -jar java-cup-11a.jar -parser Parser -symbols Symbols -interface < smallc.grm

Symbols.java: smallc.grm
	java -jar java-cup-11a.jar -parser Parser -symbols Symbols -interface < smallc.grm

Lexer.java: smallc.lex
	java -cp JFlex.jar JFlex.Main smallc.lex

clean:
	rm -f Parser.java Symbols.java Lexer.java