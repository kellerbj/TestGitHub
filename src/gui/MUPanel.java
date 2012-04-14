/* Brad Keller
 * PolyMorphism Project
 * CS 221
 * 
 * 
 * PROGRAM DETAILS:
 * 
 *     This program was made to be able to be used by two users to play a game of
 * chess. All pieces can be clicked and dragged but can only be placed in the 
 * correct location in accordance to the rules of chess. The reset button can be
 * used to set the board back to its original position.
 * 
 * 
 * I recieved help from both tutors, along with Dr. Klayder.
 */

package gui;

import gui.GraphicsPanel;
import gui.ControlPanel;
import java.awt.*;
import javax.swing.*;

public class MUPanel extends JPanel
{
    private GraphicsPanel graphicsPanel;
    private ControlPanel controlPanel;

    public MUPanel()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(520, 559));
        setName("Brad Keller's Chess Program");
        setBackground(Color.WHITE);

        graphicsPanel = new GraphicsPanel();
        add(BorderLayout.CENTER,graphicsPanel);

        controlPanel = new ControlPanel(graphicsPanel);
        add(BorderLayout.SOUTH,controlPanel);        
    } // end of MUPanel constructor

    @Override
    public void paintComponent(Graphics g)
    { // paint component
        super.paintComponent(g); // goes first
    } 
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void frame()
    {
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String args[]){new MUPanel().frame();}

} // end of class MUPanel
