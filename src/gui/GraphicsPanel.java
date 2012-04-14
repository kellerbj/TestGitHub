// This is a Panel for GraphicsPanel, which is where the chess board is displayed
package gui;

import chess.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener
{
    private int over, down, topLeftOver, topLeftDown, bottomRightOver, bottomRightDown;
    private ChessBoard chessBoard;
    private Piece selectedPiece;

    public GraphicsPanel()
    {
        setBackground(Color.WHITE);
        
        chessBoard = new ChessBoard(200, 50);
        
        // add mouse listener and mouse motion listener
        addMouseListener(this);
        addMouseMotionListener(this);
        
        selectedPiece = null;
    }
    
    public void doAReset()
    {
        chessBoard.resetBoard();
        chessBoard.setIsWhiteTurn(true);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    { // draw method
        super.paintComponent(g); // This line must be first in this method!
        
        chessBoard.drawBoard(g);
        if(selectedPiece != null)
        { 
            selectedPiece.drawPiece(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    { // listens for when mouse is clicked on screen
        over=(e.getX()/65);
        down=(e.getY()/65);
        System.out.println("mouse clicked on: "+over+", "+down);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) 
    { // listens for when mouse is pressed on screen
        topLeftOver=(e.getX()/65);
        topLeftDown=(e.getY()/65);
        selectedPiece = chessBoard.getPieceThatContainsXY(topLeftOver, topLeftDown);
        if(selectedPiece != null)
        {            
            System.out.println("mousePressed selected Piece "+selectedPiece);
        }
        else
        {
            System.out.println("no piece selected");
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    { // listens for when mouse is released on screen
        if(selectedPiece != null)
        {
            if(chessBoard.canLegallyMovePieceToXY(selectedPiece, e.getX(), e.getY()))
            { // change all of over and down indexes and pixels of the piece that was moved
                selectedPiece.setDownIndex(e.getY()/65);
                selectedPiece.setDownPixels((e.getY()/65)*65+ Utility.SQUARE_HEIGHT/2);
                selectedPiece.setOverIndex(e.getX()/65);
                selectedPiece.setOverPixels((e.getX()/65)*65+ Utility.SQUARE_WIDTH/2); 
                selectedPiece.setStartDownIndex(e.getY()/65);
                selectedPiece.setStartDownPixels((e.getY()/65)*65+ Utility.SQUARE_HEIGHT/2);
                selectedPiece.setStartOverIndex(e.getX()/65);
                selectedPiece.setStartOverPixels((e.getX()/65)*65+ Utility.SQUARE_WIDTH/2); 
                
                chessBoard.removePieceAtCertainIndex(e.getX()/65, e.getY()/65);
            }
            else
            { // return piece to where it last was on the board
                selectedPiece.returnToMostRecentLegalBoardPostion();                
            }
            
            //chessBoard.findIfThereIsAnEnemyPieceInADiagonalSquare();
            
            selectedPiece = null;
            
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    { // listens for when the mouse is dragged on the screen
        bottomRightOver=(e.getX()/65);
        bottomRightDown=(e.getY()/65);
        if(selectedPiece != null)
        { // moves the piece
            selectedPiece.setOverPixels(e.getX());
            selectedPiece.setDownPixels(e.getY());
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
} // end of GraphicsPanel