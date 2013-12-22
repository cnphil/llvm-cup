package smallc.parser;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import smallc.parser.ast.*;

public class ParserTest {

    private static void parse(String filename, String outfile) {
        try (InputStream inp = new FileInputStream(filename)) {
            Parser parser = new Parser(inp);
            Shared shared = new Shared();
            java_cup.runtime.Symbol parseTree = parser.parse();
            Program program = (Program) parseTree.value;
            System.out.println(filename);
            //System.out.println(parseTree.value);
            //System.out.println(program);
            program.codegen(shared);
            
            shared.pleaseReplace();
            
            PrintWriter writer = new PrintWriter(outfile, "UTF-8");
            writer.println(shared.buffer);
            writer.close();
        }
        catch (Exception e) {
            System.out.println("syntax error");
        }
    }

    public static void main(String[] argv) {
        parse(argv[0], argv[1]);
    }
}
