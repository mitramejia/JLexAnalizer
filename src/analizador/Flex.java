package analizador;

import java.io.File;
import java.io.StringReader;
import java.util.Stack;
import javax.swing.JOptionPane;
import static javax.swing.SwingUtilities.invokeLater;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flex {

    private static final char L_PAREN = '(';
    private static final char R_PAREN = ')';
    private static final Logger LOGGER = Logger.getLogger(Flex.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Logger Name: {0}", LOGGER.getName());

        try {
            generadorLexer(getLexerFilePath());        
            AnalizadorJFrame jframe = new AnalizadorJFrame();
            
            invokeLater(new Runnable() {
            public void run() {
                jframe.setVisible(true);
            }
        });
            /*
            //Conseguir el path relativo del lexer.flex. Más conveniente.
            generadorLexer(getLexerFilePath());

            String input = (JOptionPane.showInputDialog("Ingrese la expresion"));
            AnalizadorJFlex analizador = new AnalizadorJFlex(new StringReader(input));
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    System.out.println(analizer.yylex());
                }
                if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == '^') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    System.out.println(analizer.yylex());
                }
                if (input.charAt(i) == ' ') {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
                    System.out.println(analizer.yylex());
                }
            }

            if (isBalanced(input) == true) {
                //si el stack está vacio, ejecutar este proceso.
                System.out.println("Expresion Regular=" + analizador.yylex());
                System.out.println("La expresión está balanceada.");
            } else {
                //Si el stack no está vacio, imprimir mensaje.
                System.out.println("La expresión es invalida. Confirme los paréntesis e intente de nuevo.");
            }
            
            */

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "ERROR LEXICO", ex);
        }

    }

    public static void generadorLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);

//		JFlex.Main.generate(file);
    }

    public static boolean isBalanced(String s) {
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

    private static String getLexerFilePath() {
        //Método para conseguir el path.
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

}
