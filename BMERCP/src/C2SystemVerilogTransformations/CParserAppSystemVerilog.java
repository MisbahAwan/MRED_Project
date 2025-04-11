package C2SystemVerilogTransformations;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CParserAppSystemVerilog {
    public static void main(String[] args) throws Exception {
        // Load the input SystemVerilog code
    	String inputFilePath = args[0];
        String outputFilePath = args[1];

        //String inputFilePath = "VerilogTestInput.txt";
        CharStream input = CharStreams.fromPath(Paths.get(inputFilePath));

        // Create a lexer and parser
        C2SystemVerilogLexer lexer = new C2SystemVerilogLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        C2SystemVerilogParser parser = new C2SystemVerilogParser(tokens);

        // Parse the input code
        ParseTree tree = parser.file();
    
        // Visit the parse tree to generate C code
        CToSystemVerilogVisitor visitor = new CToSystemVerilogVisitor();
        String cCode = visitor.visit(tree);
        

        // Write the generated C code to an output file
        //String outputFilePath = "OutputFile.txt";
        writeToFile(outputFilePath, cCode);

        System.out.println("C code has been written to " + outputFilePath);
    }

    private static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
