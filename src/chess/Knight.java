// This is a class for Knight which is a subclass to Piece
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Knight extends Piece
{
    public Knight(int overIndex, int downIndex, boolean isWhite, ChessBoard chessBoard)
    {
        super(overIndex, downIndex, isWhite, chessBoard);
    }    
    
    @Override
    public void drawPiece(Graphics g)
    { // draws Knight
        super.drawPiece(g);
        g.fillOval(overPixels-Utility.PIECE_CHARACTER_OVER_OFFSET, downPixels-Utility.PIECE_CHARACTER_DOWN_OFFSET, 
                        Utility.PIECE_HEIGHT, Utility.PIECE_WIDTH); 
        
        // sets contrast color
        if(isWhite)
        {
            g.setColor(Color.BLACK);
        }
        else
        {
            g.setColor(Color.WHITE);
        }
        g.setFont(new Font("sansserrif", Font.BOLD, 48));
        g.drawString("♘", overPixels-27, downPixels+18);
    }
    
    private boolean legalCheckForKnight(int startOver, int startDown, int destinationOver, int destinationDown)
    { // checks to see if desired move is legal for the knight (2&1)
        if(Utility.isKnightMove(startOver, startDown, destinationOver, destinationDown))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean canLegallyMovePieceToXY(int x, int y)
    { // checks to see if knight can be moved to desired location
        int destinationOver = Utility.convertPixelsOverToIndex(x);
        int destinationDown = Utility.convertPixelsDownToIndex(y);
        
        return legalCheckForKnight(super.getStartOverIndex(), super.getStartDownIndex(),
                destinationOver, destinationDown);
    }    
} // end of Knight