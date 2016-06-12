/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ExpresionPanel extends JPanel implements ActionListener{
    
    
    public ExpresionPanel(){
        // Set layout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        /**
         * Create UI components
        */
        
        JLabel jLabelResult = new JLabel("Result");
        JLabel jLabelTerms = new JLabel("Terms");
        JTextField jTextFieldExpression = new JTextField("Expresión...");
        JButton jButtonEvaluate = new JButton("Evaluar");
        JButton jButtonAddExpression = new JButton("+Agregar");
        
        // Action Listernes
        jButtonEvaluate.addActionListener(this);
        
        // Add components to layout
        
        // First row
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(jTextFieldExpression)
                .addComponent(jLabelTerms)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEvaluate)
                    .addComponent(jButtonAddExpression))
        );
        
//        //
//        layout.setVerticalGroup(
//            layout.createSequentialGroup()
//               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                    .addComponent(c1)
//                    .addComponent(c2)
//                    .addComponent(c3))
//               .addComponent(c4)
//         );

        
        jButtonAddExpression.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                jButtonAddExpressionActionPerformed(event);
            }
        });
    
    }
    
     private void jButtonAddExpressionActionPerformed(ActionEvent event) {                                                     
        // TODO add your handling code here:
        JFrame parentJFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        parentJFrame.add(new ExpresionPanel(), BorderLayout.AFTER_LAST_LINE);
    }          

    public void actionPerformed(ActionEvent evt)
    {
        this.revalidate();
    }
}
