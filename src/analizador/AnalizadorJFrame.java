/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import analizador.Flex;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import static javax.swing.SwingUtilities.invokeLater;

/**
 *
 * @author mitramejia
 */
public class AnalizadorJFrame extends JFrame{
    
    private AnalizadorJFlex analizador;
    
    
    public AnalizadorJFrame(ExpressionCounter counter) {
        
        this.setSize(400, 150);
        this.setTitle("Analizador JFlex");
                 
        // Manin panel contanining the scroll pane
        JPanel mainPanel = new JPanel();
        
        // Le paso el objeto contador al JPanel
        ExpressionPanel expresionPanel = new ExpressionPanel(counter);

        // Scrollpane
        JScrollPane listScroller = new JScrollPane();
        mainPanel.add(listScroller);
        this.add(expresionPanel);
        this.setVisible(true);
      
    }
     
    
        public static void main(String[] args) {
            
           
            try {
                // Como el programa debe evaluar no mas de 10 expresiones, instancio el contador al abrir la ventana.
                // El objeto contador pasa del Jframe al JPanel.
                ExpressionCounter counter = new ExpressionCounter();              
                AnalizadorJFrame jframe = new AnalizadorJFrame(counter);

                invokeLater(new Runnable() {
                    public void run() {
                        jframe.setVisible(true);
                    }
                });

            } catch (Exception e) {
                throw e;
            }

    }
    
        /**
     * @return the analizador
     */
    public AnalizadorJFlex getAnalizador() {
        return analizador;
    }

    /**
     * @param analizador the analizador to set
     */
    public void setAnalizador(AnalizadorJFlex analizador) {
        this.analizador = analizador;
    }
    
    
}
