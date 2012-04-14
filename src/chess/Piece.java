// This is a class for the Piece
package chess;

import java.awt.*;

public class Piece 
{ 
    public int overIndex, downIndex, overPixels, downPixels, startOverIndex, startDownIndex,
            startOverPixels, startDownPixels;
    public boolean isWhite, canMoveDiagonal;
    public Color pieceColor;
    protected ChessBoard chessBoard;
    
    public Piece(int overIndex, int downIndex, boolean isWhite, ChessBoard chessBoard)
    {
        this.overIndex=overIndex;
        this.downIndex=downIndex;
        this.isWhite=isWhite;
        
        overPixels = Utility.convertIndexOverToPixels(overIndex);
        downPixels = Utility.convertIndexDownToPixels(downIndex);
        
        startOverIndex = overIndex;
        startDownIndex = downIndex;
        
        startOverPixels = overPixels;
        startDownPixels = downPixels;
        
        this.chessBoard=chessBoard;
    }
    
    public void drawPiece(Graphics g)
    { // decided whether piece is white or black
      // is OverRidden by subclasses  
        if(isWhite)
        {
            g.setColor(Color.WHITE);
        }
        else
        {
            g.setColor(Color.BLACK);
        }        
    }
    
    public void setCanMoveDiagonal(boolean canMoveDiagonal)
    {
        this.canMoveDiagonal=canMoveDiagonal;
    }
    
    public boolean getCanMoveDiagonal()
    {
        return canMoveDiagonal;
    }
    
    public boolean getIsWhite()
    { // returns whether piece is white or black
        return isWhite;
    }
    
    public void setIsWhite(boolean isWhite)
    { // sets if piece is white or black
        this.isWhite=isWhite;
    }
    
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
    
    public int getOverIndex()
    { // returns the over value of the piece in INDEX FORM  
        return overIndex;
    }
    
    public int getStartOverIndex()
    { // returns the last legal INDEX over of the piece
        return startOverIndex;
    }    
    
    public int getDownIndex()
    { // returns the down value of the piece in INDEX FORM
        return downIndex;
    }

    public int getStartDownIndex()
    { // returns the last legal INDEX down of the piece
        return startDownIndex;
    }

    public void setOverIndex(int overIndex)
    { // sets the over INDEX of the piece
        this.overIndex=overIndex;
    }
    
    public void setDownIndex(int downIndex)
    { // sets the down INDEX of the piece
        this.downIndex=downIndex;
    }
    
    public void setOverPixels(int overPixels)
    { // sets the over PIXELS of the piece
        this.overPixels=overPixels;
    }
    
    public void setDownPixels(int downPixels)
    { // sets the down PIXELS of the piece
        this.downPixels=downPixels;
    }

    public void setStartOverIndex(int startOverIndex)
    { // sets the last legal over of the piece in INDEX FORM
        this.startOverIndex=startOverIndex;
    } 
    
    public void setStartOverPixels(int startOverPixels)
    { // sets the last legal over of the piece in PIXELS
        this.startOverPixels=startOverPixels;
    }    

    public void setStartDownIndex(int startDownIndex)
    { // sets the last legal down of the piece in INDEX FORM
        this.startDownIndex=startDownIndex;
    }

    public void setStartDownPixels(int startDownPixels)
    { // sets the last legal down of the piece in PIXELS
        this.startDownPixels=startDownPixels;
    }
    
    public boolean canLegallyMovePieceToXY(int x, int y)
    { // returns if the piece can legally be moved to the desired X and Y coordinates
      // gets OverRidden by subclasses  
        System.out.println("in Piece, in canLegallyMovePieceToXY");
        return true;
    }
       
    public boolean contains(int mouseOverIndex, int mouseDownIndex)
    { // returns whether the mouse is clicked within a piece
        if(mouseOverIndex == overIndex && mouseDownIndex == downIndex)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
//    public void setEnemyInDiagonalSquare(Piece enemyPiece, int startOverIndex, int startDownIndex,
//            int enemyOverIndex, int enemyDownIndex)
//    {
//        if(isWhite == true)
//        {
//            if((enemyPiece.getOverIndex() == startOverIndex+1 && enemyPiece.getDownIndex() == startDownIndex-1)
//                    || (enemyPiece.getOverIndex() == startOverIndex-1 && enemyPiece.getDownIndex() == startDownIndex-1))
//            {                
//                canMoveDiagonal = true;
//                System.out.println("BLACK ENEMY IS IN DIAGONAL SQUARE, CANMOVEDIAGONAL: "+canMoveDiagonal);
//            }
//            else
//            {
//                canMoveDiagonal = false;
//                System.out.println("NO ENEMY IN DIAGONAL SQUARE, CANMOVEDIAGONAL: "+canMoveDiagonal);
//            }
//        }
//        else
//        {
//            if((enemyPiece.getOverIndex() == startOverIndex+1 && enemyPiece.getDownIndex() == startDownIndex+1)
//                    || (enemyPiece.getOverIndex() == startOverIndex-1 && enemyPiece.getDownIndex() == startDownIndex+1))
//            {
//                canMoveDiagonal = true;
//                System.out.println("WHITE ENEMY IS IN DIAGONAL SQUARE, CANMOVEDIAGONAL: "+canMoveDiagonal);
//            }
//            else
//            {
//                canMoveDiagonal = false;
//                System.out.println("NO ENEMY IN DIAGONAL SQUARE, CANMOVEDIAGONAL: "+canMoveDiagonal);
//            }
//        }
//    }
    
    public void returnToMostRecentLegalBoardPostion()
    { // returns piece to most recent legal position on the board
        overPixels = startOverPixels;
        downPixels = startDownPixels;
        overIndex = startOverIndex;
        downIndex = startDownIndex;
    }
    
    @Override
    public String toString()
    { // writes out the toString of piece
        return "Piece over= "+overIndex+" Piece down= "+downIndex;
    }
} // end of Piece