// This is a class for Utility, which is used as a way to store data that will 
// be used in other parts of the program
package chess;

public class Utility 
{
    // declared static final int's to be used in other classes
    public static final int SQUARE_WIDTH = 65;
    public static final int SQUARE_HEIGHT = 65;
    
    static final int PIECE_WIDTH = 65;
    static final int PIECE_HEIGHT = 65;
    
    static final int PIECE_CHARACTER_OVER_OFFSET = 32;
    static final int PIECE_CHARACTER_DOWN_OFFSET= 32;
    
//    static boolean pawnHasMoved=false;
        
    static int convertPixelsOverToIndex(int mouseOver)
    { // converts number of pixels over into the index
        int answer = (mouseOver/SQUARE_WIDTH);
        return answer;
    }
    
    static int convertPixelsDownToIndex(int mouseDown)
    { // converts number of pixels down into the index
        int answer = (mouseDown/SQUARE_HEIGHT);
        return answer;
    }
    
    static int convertIndexOverToPixels(int indexOver)
    { // converts the index over number into pixels
        int answer = (indexOver * SQUARE_WIDTH)+ SQUARE_WIDTH/2;
        return answer;
    }
    
    static int convertIndexDownToPixels(int indexDown)
    { // converts the index down number into pixels
        int answer = (indexDown * SQUARE_HEIGHT)+ SQUARE_HEIGHT/2;
        return answer;
    }
    
    static int convertPieceOffsetPixelsOverToIndex(int pixelsOver)
    { // converts the over offset of piece from pixels to index
        int answer = (pixelsOver/PIECE_CHARACTER_OVER_OFFSET);
        return answer;
    }
    
    static boolean indexesAreInRange(int indexOver, int indexDown)
    {
        if (indexOver < 0 || indexOver > 7 || indexDown < 0 || indexDown >7)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
        
    public static boolean isHorizontalOrVerticalMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
    { // returns whether or not a move is in the horizontal or vertical direction
        if(startOverIndex == finalOverIndex || startDownIndex == finalDownIndex)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isDiagonalMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
    { // returns whether or not a move is in the diagonal direction
        if(Math.abs(startOverIndex-finalOverIndex) == Math.abs(startDownIndex-finalDownIndex))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isKnightMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
    { // returns whether or not movement was in the form of a knight (2&1)
        if((Math.abs(startOverIndex+2)==Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)) ||
                (Math.abs(startOverIndex+2)==Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)) ||
                    (Math.abs(startOverIndex-2)==Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)) ||
                        (Math.abs(startOverIndex-2)==Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)) ||
                            (Math.abs(startOverIndex+1)==Math.abs(finalOverIndex) && Math.abs(startDownIndex+2) == Math.abs(finalDownIndex)) ||
                                (Math.abs(startOverIndex+1)==Math.abs(finalOverIndex) && Math.abs(startDownIndex-2) == Math.abs(finalDownIndex)) ||
                                    (Math.abs(startOverIndex-1)==Math.abs(finalOverIndex) && Math.abs(startDownIndex+2) == Math.abs(finalDownIndex)) ||
                                        (Math.abs(startOverIndex-1)==Math.abs(finalOverIndex) && Math.abs(startDownIndex-2) == Math.abs(finalDownIndex)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isQueenMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
    { // returns whether or not movement was in the horiz, vert, or diagonal movements
        if(startOverIndex == finalOverIndex || startDownIndex == finalDownIndex 
                || Math.abs(startOverIndex-finalOverIndex) == Math.abs(startDownIndex-finalDownIndex))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isKingMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
    { // returns whether or not movement was in the horiz, vert, or diagonal movements but only by 1 space
        if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)) ||
                (Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)) ||
                    (Math.abs(startOverIndex+1) == Math.abs(finalOverIndex) && Math.abs(startDownIndex) == Math.abs(finalDownIndex)) ||
                        (Math.abs(startOverIndex-1) == Math.abs(finalOverIndex) && Math.abs(startDownIndex) == Math.abs(finalDownIndex)) ||
                            (Math.abs(startOverIndex-1) == Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)) ||
                                (Math.abs(startOverIndex+1) == Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)) ||
                                    (Math.abs(startOverIndex-1) == Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)) ||
                                        (Math.abs(startOverIndex+1) == Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
//    public static boolean isPawnMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
//    { // returns whether or not movement was forward by 1 space
//        if(pawnHasMoved == false)
//        {
//            System.out.println("this is pawn's first move");
//            
//            if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex+2) == Math.abs(finalDownIndex)))
//            {
//                pawnHasMoved = true;
//                return true;
//            }
//            else if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)))
//            {
//                pawnHasMoved = true;
//                return true;                
//            }
//            else
//            {
//                return false;
//            }            
//        }
//        
//        if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex+1) == Math.abs(finalDownIndex)))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        } 
//    }
    
//    public static boolean isWhitePawnMove(int startOverIndex, int startDownIndex, int finalOverIndex, int finalDownIndex)
//    { // returns whether or not movement was forward by 1 space
//        if(pawnHasMoved == false)
//        {
//            System.out.println("this is pawn's first move");
//            
//            if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex-2) == Math.abs(finalDownIndex)))
//            {
//                pawnHasMoved = true;
//                return true;
//            }
//            else if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)))
//            {
//                pawnHasMoved = true;
//                return true;                
//            }
//            else
//            {
//                return false;
//            }            
//        }
//        
//        if((Math.abs(startOverIndex) == Math.abs(finalOverIndex) && Math.abs(startDownIndex-1) == Math.abs(finalDownIndex)))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        } 
//    }
} // end Utility