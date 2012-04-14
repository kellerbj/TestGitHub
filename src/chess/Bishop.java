// This class is for Bishop and is a subclass of Piece.
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Bishop extends Piece
{
    public Bishop(int overIndex, int downIndex, boolean isWhite, ChessBoard chessBoard)
    {
        super(overIndex, downIndex, isWhite, chessBoard);
    }   
    
    @Override
    public void drawPiece(Graphics g)
    { // draws Bishop
        super.drawPiece(g);
        g.fillOval(overPixels-Utility.PIECE_CHARACTER_OVER_OFFSET, downPixels-Utility.PIECE_CHARACTER_DOWN_OFFSET, 
                        Utility.PIECE_HEIGHT, Utility.PIECE_WIDTH); 
        
        // make symbol contrast color
        if(isWhite)
        {
            g.setColor(Color.BLACK);
        }
        else
        {
            g.setColor(Color.WHITE);
        }
        g.setFont(new Font("sansserrif", Font.BOLD, 48));
        g.drawString("♗", overPixels-24, downPixels+18);
    }
    
    private boolean legalCheckForBishop(int startOver, int startDown, int destinationOver, int destinationDown)
    { // checks for legal diagonal move
        if(Utility.isDiagonalMove(startOver, startDown, destinationOver, destinationDown))
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
    { // returns if move is legal
        int destinationOver = Utility.convertPixelsOverToIndex(x);
        int destinationDown = Utility.convertPixelsDownToIndex(y);
        
        return legalCheckForBishop(super.getStartOverIndex(), super.getStartDownIndex(),
                destinationOver, destinationDown);
    }     
} // end of bishop