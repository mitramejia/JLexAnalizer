/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author mitramejia
 * 
 * This class is meant to be dynamically created and added to the AnalizadorJframe when the
 * user clicks the '+Agregar' button.
 */
public class ExpressionPanel extends JPanel implements ActionListener{
    
    private static final Logger LOGGER = Logger.getLogger(Flex.class.getName());
    
    public ExpressionPanel(ExpressionCounter manager){
        // Set layout
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        /**
         * Create UI components
        */
 
  
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        boolean shouldFill = true;
        boolean shouldWeightX = true;
        
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        
        // Add Textfield
        JTextField jTextFieldExpression = new JTextField("Expresión...");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        this.add(jTextFieldExpression, c);

        // Add Terms label
        JLabel jLabelTerms = new JLabel("Terms");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        this.add(jLabelTerms, c);

        // Add Evaluate button
        JButton jButtonEvaluate = new JButton("Evaluar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(jButtonEvaluate, c);
        
        // Add Result label
        JLabel jLabelResult = new JLabel("Result");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;      //make this component tall
         c.ipadx = 10;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(jLabelResult, c);

        // Add new Expression button    
        JButton jButtonAddExpression = new JButton("+Agregar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridwidth = 3;
        c.gridx = 0;       //aligned with button 2
        c.gridy = 2;       //third row
        this.add(jButtonAddExpression, c);
        
        
        // Action Listernes
        jButtonEvaluate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String input = (String)jTextFieldExpression.getText();
                    Flex flex = new Flex();
                    flex.evaluateExpression(input);
                    manager.increaseSectionCount();
                } catch(Exception e) {
                    LOGGER.log(Level.SEVERE, "Error: {0}", e);
                }
               
            }
        });
        
        
        jButtonAddExpression.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               
               
            }
        });
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
