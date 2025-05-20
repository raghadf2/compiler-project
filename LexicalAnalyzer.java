import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {

    private static final String KEYWORD = "\\b(start|finish|then|if|repeat|var|int|float|do|read|print|void|return)\\b";
    private static final String IDENTIFIER = "\\b[a-zA-Z][a-zA-Z0-9]{0,7}\\b";  
    private static final String NUMBER = "-?\\d{1,8}";  
    private static final String OPERATOR = "==|!=|=<|=>|<|>|=|\\+|-|\\*|/|%";  
    private static final String DELIMITER = "[.,;{}()]";  
    private static final String WHITESPACE = "\\s+";  
    private static final String COMMENT = "//.*";  

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
        "(" + KEYWORD + ")|" +
        "(" + IDENTIFIER + ")|" +
        "(" + NUMBER + ")|" +
        "(" + OPERATOR + ")|" +
        "(" + DELIMITER + ")|" +
        "(" + WHITESPACE + ")|" +
        "(" + COMMENT + ")"
    );

    public static List<String[]> analyzeProgram(String filePath) throws IOException {
        List<String[]> tokens = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = reader.readLine()) != null) {  
            Matcher matcher = TOKEN_PATTERN.matcher(line);  
            while (matcher.find()) {  
                if (matcher.group(1) != null) {
                    tokens.add(new String[] {matcher.group(), "KEYWORD"});
                } else if (matcher.group(2) != null) {
                    tokens.add(new String[] {matcher.group(), "IDENTIFIER"});
                } else if (matcher.group(3) != null) {
                    tokens.add(new String[] {matcher.group(), "NUMBER"});
                } else if (matcher.group(4) != null) {
                    tokens.add(new String[] {matcher.group(), "OPERATOR"});
                } else if (matcher.group(5) != null) {
                    tokens.add(new String[] {matcher.group(), "DELIMITER"});
                } else if (matcher.group(6) != null) {
                    // Ignore whitespace
                } else if (matcher.group(7) != null) {
                    tokens.add(new String[] {matcher.group(), "COMMENT"});
                } else {
                    tokens.add(new String[] {matcher.group(), "ERROR"});  
                }
            }
        }
        
        reader.close();  
        return tokens;
    }

    public static void printTokens(List<String[]> tokens) {
        for (String[] token : tokens) {
            if (token[1].equals("ERROR")) {
                // Custom error message based on the token's pattern
                if (token[0].matches("\\d{9,}")) {
                    System.out.println("Error: Number '" + token[0] + "' exceeds the allowed 8 digits.");
                } else if (token[0].matches("@")) {
                    System.out.println("Error: Invalid character '" + token[0] + "' found.");
                } else {
                    System.out.println("Error: Unrecognized token '" + token[0] + "'");
                }
            } else {
                System.out.println("Token: " + token[0] + ", Class: " + token[1]);
            }
        }
    }

    public static void main(String[] args) {
        try {
            List<String[]> tokens = analyzeProgram("program.txt");  
            printTokens(tokens);  
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

