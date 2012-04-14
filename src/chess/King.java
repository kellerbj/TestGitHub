// This is a class made for King which is a subclass to Piece
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class King extends Piece
{
    public King(int overIndex, int downIndex, boolean isWhite, ChessBoard chessBoard)
    {
        super(overIndex, downIndex, isWhite, chessBoard);
    }   
    
    @Override
    public void drawPiece(Graphics g)
    { // draws King
        super.drawPiece(g);
        g.fillOval(overPixels-Utility.PIECE_CHARACTER_OVER_OFFSET, downPixels-Utility.PIECE_CHARACTER_DOWN_OFFSET, 
                        Utility.PIECE_HEIGHT, Utility.PIECE_WIDTH); 
        
        // sets the contrast color
        if(isWhite)
        {
            g.setColor(Color.BLACK);
        }
        else
        {
            g.setColor(Color.WHITE);
        }
        
        g.setFont(new Font("sansserrif", Font.BOLD, 48));
        g.drawString("♔", overPixels-24, downPixels+18);
    }
    
    private boolean legalCheckForKing(int startOver, int startDown, int destinationOver, int destinationDown)
    { // checks to see if desired move is legal (any direction by only 1 square)
        if(Utility.isKingMove(startOver, startDown, destinationOver, destinationDown))
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
    { // checks to see if piece can be placed in desired place
        int destinationOver = Utility.convertPixelsOverToIndex(x);
        int destinationDown = Utility.convertPixelsDownToIndex(y);
        
        return legalCheckForKing(super.getStartOverIndex(), super.getStartDownIndex(),
                destinationOver, destinationDown);
    }    
} // end of King