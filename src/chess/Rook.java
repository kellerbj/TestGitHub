// This is a class for Rook which is a subclass of Piece
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Rook extends Piece
{
    public Rook(int overIndex, int downIndex, boolean isWhite, ChessBoard chessBoard)
    {
        super(overIndex, downIndex, isWhite, chessBoard);        
    }
        
    @Override
    public void drawPiece(Graphics g)
    { // draws the Rook       
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
        g.drawString("♖", overPixels-24, downPixels+18);
    }
    
    @Override
    public Color getPieceColor()
    {
        if(isWhite)
        {
            return Color.WHITE;
        }
        else
        {
            return Color.BLACK;
        }
    }

    
    private boolean legalCheckForRook(int startOver, int startDown, int destinationOver, int destinationDown)
    { // checks for legal move for rook (horiz and vert)
        if(Utility.isHorizontalOrVerticalMove(startOver, startDown, destinationOver, destinationDown))
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
    { // returns if piece can legally move to position desired
        System.out.println("in rook subclass, canLegallyMovePieceToXY");
        
        int destinationOver = Utility.convertPixelsOverToIndex(x);
        int destinationDown = Utility.convertPixelsDownToIndex(y);
        
        
        return legalCheckForRook(super.getStartOverIndex(), super.getStartDownIndex(),
                destinationOver, destinationDown);
    } 
    
//    public boolean hasPieceBlockingMovement(int finalOverIndex, int finalDownIndex)
//    {
//        for()
//    }
    

} // end of rook