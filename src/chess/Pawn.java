// This is a class for the Black Pawn which is a subclass to Piece
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Pawn extends Piece
{    
    private boolean pawnHasMoved=false;
    private boolean enemyDiagonal=false;
    
    public Pawn(int overIndex, int downIndex, boolean isWhite, ChessBoard chessBoard)
    {
        super(overIndex, downIndex, isWhite, chessBoard);               
    }
        
    @Override
    public void drawPiece(Graphics g)
    { // draws the Pawn
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
        g.drawString("♙", overPixels-24, downPixels+18);
    }
    
    public boolean isPawnMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
    { // returns whether or not movement was forward by 1 space
        if(pawnHasMoved == false)
        {
            System.out.println("pawnHasMoved: "+pawnHasMoved);
            if(startOverIndex == finalOverIndex && startDownIndex+2 == finalDownIndex) // FOR FIRST MOVE ONLY!!!
            {
                if(chessBoard.hasPieceAt(finalOverIndex, finalDownIndex)==false)
                {
                    pawnHasMoved = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if(finalOverIndex == startOverIndex && finalDownIndex == startDownIndex+1)
            {
                if(chessBoard.hasPieceAt(finalOverIndex, finalDownIndex)==false)
                {
                    pawnHasMoved = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if((finalOverIndex == startOverIndex+1 && finalDownIndex == startDownIndex+1) ||
                        finalOverIndex == startOverIndex-1 && finalDownIndex == startDownIndex+1)
            {
                if(chessBoard.hasPieceAt(finalOverIndex, finalDownIndex)==true)
                {
                    pawnHasMoved = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                System.out.println("RETURNING FALSE");
                return false;
            }
        }
        if(pawnHasMoved == true);
        {
            System.out.println("pawnHasMoved: "+pawnHasMoved);
            if(finalOverIndex == startOverIndex && finalDownIndex == startDownIndex+1)
            {
                if(chessBoard.hasPieceAt(finalOverIndex, finalDownIndex)==false)
                {
                    pawnHasMoved = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if((finalOverIndex == startOverIndex+1 && finalDownIndex == startDownIndex+1) ||
                        finalOverIndex == startOverIndex-1 && finalDownIndex == startDownIndex+1)
            {
                if(chessBoard.hasPieceAt(finalOverIndex, finalDownIndex)==true)
                {
                    pawnHasMoved = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }            
    }
    
    @Override
    public boolean canLegallyMovePieceToXY(int x, int y)
    { // checks to see if Pawn can be moved to desired location
        int destinationOver = Utility.convertPixelsOverToIndex(x);
        int destinationDown = Utility.convertPixelsDownToIndex(y);
        
        return isPawnMove(super.getStartOverIndex(), super.getStartDownIndex(),
                destinationOver, destinationDown);
    }
    
} // end Pawn