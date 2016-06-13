package analizador;

import java.io.File;
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
    public Flex) {
        File file = new File(getLexerFilePath());
        jflex.Main.generate(file);
    }
    
    // Recibe una expresion y la evalua
    public String[] evaluateExpression(String input){
        try {
            
            AnalizadorJFlex analizador = new AnalizadorJFlex(new StringReader(input));
            String result[] = null;    
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    result[0] += analizer.yylex();
                }
                if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '^') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    result[0] += "/n" + analizer.yylex();
                }
                if (input.charAt(i) == ' ') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    result[0] += "/n" + analizer.yylex();
                }
            }

            if (isBalanced(input) == true) {
                //si el stack está vacio, ejecutar este proceso.
                System.out.println("Expresion Regular=" + analizador.yylex());
                LOGGER.log(Level.SEVERE, "ERROR LEXICO", ex);
                
                System.out.println("La expresión está balanceada.");
            } else {
                //Si el stack no está vacio, imprimir mensaje.
                System.out.println("La expresión es invalida. Confirme los paréntesis e intente de nuevo.");
            }
            
            return result;
        
          } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "ERROR LEXICO", ex);
        }
        
        
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
    
    public void resetSections(){
        this.setSectionCount(0);
    }

    public void increaseSectionCount(){
        this.sectionCount++;
    }
    
    /**
     * @return the sectionCount
     */
    public int getSectionCount() {
        return sectionCount;
    }
   

    /**
     * @param sectionCount the sectionCount to set
     */
    public void setSectionCount(int sectionCount) {
        this.sectionCount = sectionCount;
    }

}
