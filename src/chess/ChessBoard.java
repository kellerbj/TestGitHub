// This is a class for the ChessBoard
package chess;

import java.awt.*;
import java.util.*;

public class ChessBoard 
{
    private int over, down;
    private Square[][] board;
    private Piece piece, selectedPiece;
    private ArrayList <Piece> listOfPieces;
    private boolean isWhiteTurn=true;    
    
    public ChessBoard(int over, int down)
    {
        this.over=over;
        this.down=down;
        
        // draws the squares on the chess board
        board = new Square[8][8];
        for(int x=0;x<board.length;x++)
        {
            for(int y=0;y<board[0].length;y++)
            {
                board[x][y]=new Square();
            }
        }
        
        listOfPieces = new ArrayList();
        
        selectedPiece=null;
        
        resetBoard();        
    }
    
    public final void resetBoard()
    { // used to set board back to original position
        System.out.println("resetBoard");
        
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                board[i][j].setPiece(null);
            }
        }
        
        listOfPieces.clear();
                
        // BLACK PIECES
        // #1
        piece= new Rook(0, 0, false, this);
        listOfPieces.add(piece);
        
        // #2
        piece= new Knight(1, 0, false, this);
        listOfPieces.add(piece);
        
        // #3
        piece= new Bishop(2, 0, false, this);
        listOfPieces.add(piece);
        
        // #4
        piece= new Queen(3, 0, false, this);
        listOfPieces.add(piece);

        // #5
        piece= new King(4, 0, false, this);
        listOfPieces.add(piece);

        // #6
        piece= new Bishop(5, 0, false, this);
        listOfPieces.add(piece);

        // #7
        piece= new Knight(6, 0, false, this);
        listOfPieces.add(piece);

        // #8
        piece= new Rook(7, 0, false, this);
        listOfPieces.add(piece);
        
        // #9
        piece= new Pawn(0, 1, false, this);
        listOfPieces.add(piece);
        
        // #10
        piece= new Pawn(1, 1, false, this);
        listOfPieces.add(piece);
        
        // #11
        piece= new Pawn(2, 1, false, this);
        listOfPieces.add(piece);
        
        // #12
        piece= new Pawn(3, 1, false, this);
        listOfPieces.add(piece);
       
        // #13
        piece= new Pawn(4, 1, false, this);
        listOfPieces.add(piece);
        
        // #14
        piece= new Pawn(5, 1, false, this);
        listOfPieces.add(piece);

        // #15
        piece= new Pawn(6, 1, false, this);
        listOfPieces.add(piece);

        // #16
        piece= new Pawn(7, 1, false, this);
        listOfPieces.add(piece);

        // WHITE PIECES
        // #17
        piece= new WhitePawn(0, 6, true, this);
        listOfPieces.add(piece);
        
        // #18
        piece= new WhitePawn(1, 6, true, this);
        listOfPieces.add(piece);
        
        // #19
        piece= new WhitePawn(2, 6, true, this);
        listOfPieces.add(piece);
        
        // #20
        piece= new WhitePawn(3, 6, true, this);
        listOfPieces.add(piece);

        // #21
        piece= new WhitePawn(4, 6, true, this);
        listOfPieces.add(piece);

        // #22
        piece= new WhitePawn(5, 6, true, this);
        listOfPieces.add(piece);

        // #23
        piece= new WhitePawn(6, 6, true, this);
        listOfPieces.add(piece);

        // #24
        piece= new WhitePawn(7, 6, true, this);
        listOfPieces.add(piece);
        
        // #25
        piece= new Rook(0, 7, true, this);
        listOfPieces.add(piece);
        
        // #26
        piece= new Knight(1, 7, true, this);
        listOfPieces.add(piece);
        
        // #27
        piece= new Bishop(2, 7, true, this);
        listOfPieces.add(piece);
        
        // #28
        piece= new Queen(3, 7, true, this);
        listOfPieces.add(piece);
       
        // #29
        piece= new King(4, 7, true, this);
        listOfPieces.add(piece);
        
        // #30
        piece= new Bishop(5, 7, true, this);
        listOfPieces.add(piece);

        // #31
        piece= new Knight(6, 7, true, this);
        listOfPieces.add(piece);

        // #32
        piece= new Rook(7, 7, true, this);
        listOfPieces.add(piece);         
    }
    
    public void drawBoard(Graphics g)
    { // draws board with pieces
        for(int x=0;x<board.length;x++)
        {
            for(int y=0;y<board[0].length;y++)
            {
                board[x][y].drawSquare(g);
            }
        }
        for(int i=0;i<listOfPieces.size();i++)
        {
            listOfPieces.get(i).drawPiece(g);
        }
    }
        
    public Piece getPieceThatContainsXY(int x, int y)
    { // return the piece that contains the certain X and Y coordinates
        for(int i=0;i<listOfPieces.size();i++)
        {
            if(listOfPieces.get(i).contains(x,y))
            {
                selectedPiece=listOfPieces.get(i);
                return selectedPiece;
            }           
        }
        
        return null;
    }
    
    public boolean canLegallyMovePieceToXY(Piece selectedPiece, int x, int y)
    { // returns if piece can be moved legally so that can be used in GraphicsPanel
        if(isWhiteTurn == true)
        {
            if(selectedPiece.canLegallyMovePieceToXY(x, y)== true  && selectedPiece.getIsWhite()== true)
            {
                isWhiteTurn = false;
                System.out.println("isWhiteTurn: "+isWhiteTurn+"     selectedPieceIsWhite: "+selectedPiece.getIsWhite());
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {            
            if(selectedPiece.canLegallyMovePieceToXY(x, y)== true && selectedPiece.getIsWhite()== false)
            {
                isWhiteTurn = true;
                System.out.println("isWhiteTurn: "+isWhiteTurn+"    selectedPieceIsWhite: "+selectedPiece.getIsWhite());
                return true;
            }
            else
            {
                return false;
            }
        }        
    }    
    
    public void removePieceAtCertainIndex(int indexOver, int indexDown)
    {
        boolean isPieceInSquare=false;
        
        for(int i=0;i<listOfPieces.size();i++)
        {
            if(indexOver == listOfPieces.get(i).getStartOverIndex() && indexDown == listOfPieces.get(i).getStartDownIndex())
            {
                if(listOfPieces.get(i) != selectedPiece)                    
                {
                    System.out.println("canMoveDiagonal: "+selectedPiece.canMoveDiagonal);
                    if(selectedPiece.getIsWhite() != listOfPieces.get(i).getIsWhite())
                    {                        
                        listOfPieces.remove(i);
                        System.out.println("remove piece");
                    }
                }
            }
        }
       // findIfThereIsAnEnemyPieceInADiagonalSquare();
    }
    
    public boolean hasPieceAt(int overIndex, int downIndex)
    {
        boolean hasPiece=false;
        for(int i=0;i<listOfPieces.size();i++)
        {
            if(listOfPieces.get(i).getOverIndex()==overIndex && listOfPieces.get(i).getDownIndex()==downIndex)
            {
                hasPiece = true;
            }           
        }
        
        return hasPiece;
    }
    
//    public void findIfThereIsAnEnemyPieceInADiagonalSquare()
//    {       
//        int pieceNumber=-1;
//                
//        if(pieceNumber==-1)
//        {
//            for(int i=0;i<listOfPieces.size();i++)
//            {
//                if(listOfPieces.get(i) != selectedPiece)
//                {
//                    if(listOfPieces.get(i).getIsWhite() != selectedPiece.getIsWhite())
//                    {
//                        System.out.println("Piece #: "+i);
//
//                        selectedPiece.setEnemyInDiagonalSquare(listOfPieces.get(i), selectedPiece.getOverIndex(), 
//                            selectedPiece.getDownIndex(), listOfPieces.get(i).getOverIndex(),
//                                listOfPieces.get(i).getDownIndex());
//
//                        if(selectedPiece.getCanMoveDiagonal() == true)
//                        {
//                            pieceNumber = i;
//                            System.out.println("PIECE NUMBER= "+pieceNumber);
//                        }
//                    }
//                }
//            }
//        }        
//        if(pieceNumber < -1)
//        {
//            for(int j=0;j<pieceNumber;j++)
//            {
//                if(listOfPieces.get(j) != selectedPiece)
//                {
//                    if(listOfPieces.get(j).getIsWhite() != selectedPiece.getIsWhite())
//                    {
//                        System.out.println("Piece #: "+j);
//
//                        selectedPiece.setEnemyInDiagonalSquare(listOfPieces.get(pieceNumber), selectedPiece.getOverIndex(), 
//                                selectedPiece.getDownIndex(), listOfPieces.get(pieceNumber).getOverIndex(),
//                                    listOfPieces.get(pieceNumber).getDownIndex());
//                
//                        System.out.println("*****ENEMY PIECE FOUND IN DIAGONAL SQUARE*****");
//                    }
//                }
//            }
//        }   
//    }
             
    public void setIsWhiteTurn(boolean isWhiteTurn)
    {
        this.isWhiteTurn=isWhiteTurn;
    }             
} // end of ChessBoard