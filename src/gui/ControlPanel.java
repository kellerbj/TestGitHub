// This is the panel for ControlPanel
package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import chess.*;

public class ControlPanel extends JPanel
{
    private GraphicsPanel graphicsPanel;
    private JButton reset;

    public ControlPanel(GraphicsPanel graphicsPanel)
    {
        this.graphicsPanel = graphicsPanel;

        setBackground(new Color(102,51,0));

        // create JButton
        reset = new JButton("Reset");
 
        // add the action listener
        reset.addActionListener(new ResetButtonListener());

        // add button to Panel
        add(reset);        
    }

    private class ResetButtonListener implements ActionListener
    { // ActionListener to the Reset Button
        public void actionPerformed(ActionEvent ae) 
        {
            System.out.println("Reset");
            
            graphicsPanel.doAReset();
            
            repaint();
        }
    }
} // end of ControlPanel