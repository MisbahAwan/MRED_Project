package C2TreeTransformations;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class CParserAppTree {

    public static void main(String[] args) {
    	
    	String inputFilePath = args[0];
        String outputFilePath = args[1];
        
        //String inputFilePath = "VerilogTestInput.txt"; // Replace with your input file path

        try {
            // Read SystemVerilog code from file
            String systemVerilogCode = readFromFile(inputFilePath);

         // Create an input stream from the code
            CharStream input = CharStreams.fromString(systemVerilogCode);
            // Create a lexer
            C2TreeLexer lexer = new C2TreeLexer(input);
            // Create a token stream
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // Create a parser
            C2TreeParser parser = new C2TreeParser(tokens);
            
            // Parse the code starting from the 'file' rule
            ParseTree tree = parser.file();
            
            // Print the parse tree (for debugging)
           // System.out.println(tree.toStringTree(parser));
            
            // Create a visitor to transform the parse tree to DSML
            CToTreeVisitor visitor = new CToTreeVisitor();
            //visitor.visit(tree);
            
            // Get the generated DSML XML
            String dsmlXML = visitor.visit(tree);
            //System.out.println(dsmlXML);

            // Write output to file
            //String outputFilePath = "OutputFileTree.txt"; // Replace with your output file path
            writeToFile(outputFilePath, dsmlXML);
            
            System.out.println("Transformation completed successfully. Output written to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }

    private static void writeToFile(String filePath, String content) throws IOException {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(content);
        }
    }
}
