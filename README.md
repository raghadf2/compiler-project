Lexical Analyzer Project

Project Description
This project is a simple lexical analyzer written in Java. It reads a source code file, analyzes each line, and classifies the contents into various types of tokens such as keywords, identifiers, numbers, operators, delimiters, comments, and errors.



How It Works
The analyzer uses regular expressions (regex) to recognize and classify tokens into the following types:

| Token Type    | Description                                              |
|---------------|----------------------------------------------------------|
| `KEYWORD`     | Reserved keywords such as `start`, `finish`, `if`, etc. |
| `IDENTIFIER`  | Variable names that start with a letter and can have up to 8 alphanumeric characters |
| `NUMBER`      | Integer numbers with up to 8 digits                      |
| `OPERATOR`    | Operators such as `==`, `!=`, `+`, `-`, `*`, `/`, `%`, etc. |
| `DELIMITER`   | Symbols like `;`, `{}`, `()`, `,`, `.`                   |
| `COMMENT`     | Lines starting with `//`                                 |
| `WHITESPACE`  | Spaces, tabs, or new lines (ignored by the analyzer)     |
| `ERROR`       | Any invalid or unrecognized token                        |



📂 File Structure
LexicalAnalyzer.java -> Main source file for the analyzer
program.txt -> Input file containing source code to analyze



How to Use

1. Add your code to `program.txt`.  
2. Compile and run `LexicalAnalyzer.java`.  
3. The output will display all recognized tokens and any errors found.



Example Output
Token: start, Class: KEYWORD
Token: var, Class: KEYWORD
Token: x, Class: IDENTIFIER
Token: =, Class: OPERATOR
Token: 123456789, Class: ERROR
Error: Number '123456789' exceeds the allowed 8 digits.
Token: // this is a comment, Class: COMMENT



Requirements

- Java JDK 8 or higher  
- A text editor or Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)  
- Make sure the `program.txt` file is in the same directory as the `.java` file



🧾 Notes

- Whitespace is ignored and not printed in the output.
- Numbers longer than 8 digits are flagged as errors.
- You can customize the patterns in the code to support more language features.
