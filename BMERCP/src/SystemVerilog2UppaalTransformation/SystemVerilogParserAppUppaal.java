package SystemVerilog2UppaalTransformation;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class SystemVerilogParserAppUppaal {

    public static void main(String[] args) {
    	
    	String inputFilePath = args[0];
        String outputFilePath = args[1];
        
        //String inputFilePath = "SystemverilogFromTA.txt"; // Replace with your input file path

        try {
            // Read SystemVerilog code from file
            String systemVerilogCode = readFromFile(inputFilePath);

            // Setup ANTLR parsing
            ANTLRInputStream input = new ANTLRInputStream(systemVerilogCode);
            SystemVerilog2UppaalLexer lexer = new SystemVerilog2UppaalLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SystemVerilog2UppaalParser parser = new SystemVerilog2UppaalParser(tokens);
            ParseTree tree = parser.file();

            // Instantiate visitor and trigger transformation
            SystemVerilogToUPPAALVisitor visitor = new SystemVerilogToUPPAALVisitor();
            visitor.visit(tree);
            String uppaalXML = visitor.getUPPAALXML();

            // Write output to file
            //String outputFilePath = "OutputFileUppaal.txt"; // Replace with your output file path
            writeToFile(outputFilePath, uppaalXML);
            
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
