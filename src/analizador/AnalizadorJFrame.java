/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author mitramejia
 */
public class AnalizadorJFrame extends JFrame{
    
    private AnalizadorJFlex analizador;
    
    
    public AnalizadorJFrame() {
        this.setSize(300, 200);
        ExpresionPanel expresionPanel = new ExpresionPanel();
        JScrollPane listScroller = new JScrollPane(expresionPanel);
        
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
