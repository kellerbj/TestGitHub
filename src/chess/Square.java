// This is a class for Square which is primarily used to set the color of square
package chess;

import java.awt.*;

public class Square 
{
    private Piece piece;
    
    public Square()
    {
        piece = null;
    }
    
    public void drawSquare(Graphics g)
    { // draws a single Square
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if((i+j)%2 == 0)
                { // if it is an even number, make it dark
                    g.setColor(new Color(153, 102, 51));
                }
                else
                { // if it is an odd number, make it light
                    g.setColor(new Color(255, 204, 153));
                }
                
                g.fillRect(65*i, 65*j, Utility.SQUARE_WIDTH, Utility.SQUARE_HEIGHT);
            }
        }
    }
    
    public void setPiece(Piece piece)
    { // sets piece
        this.piece=piece;
    }    
} // end of Square