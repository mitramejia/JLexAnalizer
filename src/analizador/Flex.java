package analizador;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Stack;
import javax.swing.JOptionPane;
import static javax.swing.SwingUtilities.invokeLater;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flex {
    private final char L_PAREN = '(';
    private final char R_PAREN = ')';
    private final Logger LOGGER = Logger.getLogger(Flex.class.getName());
    
    // Genera el archivo lexer cuando el objeto Flex es instanciado
    public Flex() {
        File file = new File(getLexerFilePath());
        jflex.Main.generate(file);
    }
    
    // Recibe una expresion y la evalua
    public String[] evaluateExpression(String input){
        String[] result = null;
        String terms = "";
        String validate = "";
        
        
        try {
            
            
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    terms += "\n" +analizer.yylex().toString();
                }
                if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '^') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    terms += "\n" + analizer.yylex().toString();
                }
                if (input.charAt(i) == ' ') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    terms += "\n" + analizer.yylex().toString() + "\n";
                }
            }
            
            System.err.println(terms);
  
            if (isBalanced(input) == true) {
                //si el stack está vacio, ejecutar este proceso.
                AnalizadorJFlex analizador = new AnalizadorJFlex(new StringReader(input));
              
                System.out.println("Expresion Regular="+analizador.yylex().toString());
                
                if (!"VALIDO".equals(getTokenFromConsole(analizador.yylex()))){
                    validate = "Incorrecto";
                }
                else {
                    validate = "Correcto";
                }
            } else {
                //Si el stack no está vacio, imprimir mensaje.
                System.out.println("La expresión es invalida. Confirme los paréntesis e intente de nuevo.");
                validate = "Incorrecto. Confirme los paréntesis e intente de nuevo.";
            }
           
        
          } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "ERROR LEXICO", ex);
        }
        
        result[0] = terms;
        result[1] = validate;
        
        
        return result;
    }


    public boolean isBalanced(String s) {
        //Función para confirmar si está balanceado.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //Lee término por término en busca del caracter.
            switch (s.charAt(i)) {
                case L_PAREN:
                    //Lee un paréntesis izquierdo "(".
                    stack.push(L_PAREN);
                    //Lo pushea en un stack.
                    break;
                // Ignora los demás carácteres
                case R_PAREN:
                    //Lee paréntesis derecho ")".
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != L_PAREN) {
                        return false;
                    }
                    break;
                default:
                    //En cualquier otro caso, no analiza.
                    break;
            }

        }
        //Devuelve un true o false dependiendo del stack.
        return stack.isEmpty();
    }
    
    // Método para conseguir el path del archivo lexer.
    private String getLexerFilePath() {
       
        String dir = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        String lexerFilePath;
        if ( "Mac OS X".equals(os) || "Linux".equals(os)) {
            lexerFilePath = dir + "//src//analizador//lexer.flex";
        } else {
            lexerFilePath = dir + "\\src\\analizador\\lexer.flex";
        }
        LOGGER.info("Lexer File Path"+ lexerFilePath);
        return lexerFilePath;
    }
    
    
    public String getTokenFromConsole(Tokens token){
         // Create a stream to hold the output
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    // IMPORTANT: Save the old System.out!
    PrintStream old = System.out;
    // Tell Java to use your special stream
    System.setOut(ps);
    // Print some output: goes to your special stream
    System.out.println(token);
    // Put things back
    System.out.flush();
    System.setOut(old);
    // Show what happened
    System.out.println("Here: " + baos.toString());
    System.out.flush();
    return baos.toString();
    
    }

}
