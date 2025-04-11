package Tree2SystemVerilogTransformation;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TreeParserAppSystemVerilog {
    public static void main(String[] args) throws Exception {
    	String inputFilePath = args[0];
        String outputFilePath = args[1];
        
        //String inputFilePath = "SystemverilogFromTA.txt"; // Replace with your input file path
        System.out.println(inputFilePath);System.out.println(outputFilePath);
        try {
            // Read C code from file
            String cCode = readFromFile(inputFilePath);

            // Setup ANTLR parsing
            ANTLRInputStream input = new ANTLRInputStream(cCode);
            Tree2SystemVerilogLexer lexer = new Tree2SystemVerilogLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Tree2SystemVerilogParser parser = new Tree2SystemVerilogParser(tokens);
            ParseTree tree = parser.system();

            // Instantiate visitor and trigger transformation
            TreeToSystemVerilogVisitor visitor = new TreeToSystemVerilogVisitor();
            //visitor.visit(tree);
            String CText = visitor.visit(tree);//.visitSystem(parser.system());//getcCode();

            // Write output to file
            //String outputFilePath = "OutputFileUppaal.txt"; // Replace with your output file path
            writeToFile(outputFilePath, CText);
            
            System.out.println("Transformation completed successfully. Output written to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Read and discard the first line .. tree header line
            br.readLine(); // Read and discard the second line.. tree declaration line
            br.readLine(); // Read and discard the second line.. tree declaration line
            br.readLine(); // Read and discard the second line.. tree declaration line
            br.readLine(); // Read and discard the second line.. tree declaration line
            
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
