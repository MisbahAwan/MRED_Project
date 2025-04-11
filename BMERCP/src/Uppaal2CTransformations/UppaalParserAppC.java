package Uppaal2CTransformations;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class UppaalParserAppC {

    public static void main(String[] args) {
    	
    	String inputFilePath = args[0];
        String outputFilePath = args[1];
        
        //String inputFilePath = "SystemverilogFromTA.txt"; // Replace with your input file path
        System.out.println(inputFilePath);System.out.println(outputFilePath);
        try {
            // Read C code from file
            String cCode = readFromFile(inputFilePath);

            // Setup ANTLR parsing
            ANTLRInputStream input = new ANTLRInputStream(cCode);
            Uppaal2CLexer lexer = new Uppaal2CLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Uppaal2CParser parser = new Uppaal2CParser(tokens);
            ParseTree tree = parser.file();

            // Instantiate visitor and trigger transformation
            UppaalToCVisitor visitor = new UppaalToCVisitor();
           // visitor.visit(tree);
            String CText = visitor.visit(tree);//.getcCode();

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
            br.readLine(); // Read and discard the first line .. uppaal header line
            br.readLine(); // Read and discard the second line.. uppaal declaration line
            
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
