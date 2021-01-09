import java.beans.beancontext.BeanContext;
import java.sql.SQLOutput;
import java.util.Arrays;

public class TicTacToe {

   public static int alphaBeta(Board board, int player)
    {
            int score = scoreplayerA(board,player,-1000,1000);
        return score;
    }

    public static int scoreplayerA(Board board, int player, int alpha, int beta)
    {
        if (board.isGameWon()) {
            return  (-board.nFreeFields()-1) ;
        }
        if(board.nFreeFields()==0) {
            return 0;
        }
        for (Position move : board.validMoves()) {
            board.doMove(move, player);
            int score = scoreplayerB(board,-player, alpha, beta);

            board.undoMove(move);
            if (score > alpha) {
                alpha = score;
                if (alpha >= beta) break;
            }
        }
        return alpha;
    }
    public static int scoreplayerB(Board board, int player, int alpha, int beta)
    {
        if (board.isGameWon()) {
            return  (board.nFreeFields()+1) ;
        }
        if(board.nFreeFields()==0) {
            return 0;
        }
        for (Position move : board.validMoves()) {
            board.doMove(move, player);
            int score = scoreplayerA(board,-player, alpha, beta);

            board.undoMove(move);
            if (score < beta) {
                beta = score;
                if (beta <= alpha) break;
            }
        }
        return beta;
    }
        // TODO

    public static void evaluatePossibleMoves(Board board, int player)
    {
        System.out.println("Evaluation for player 'x':" );
        for(int z=0; z<board.Brett.length; z++){
            if (board.Brett[z]== null){
                alphaBeta(board, player);
            }else {

            }
        }


        // TODO
    }

    public static void main(String[] args)
    {
        Board test = new Board(3);

        Board Brett= new Board(3);
        Position position= new Position(2, 0);
        Brett.setField(position,1);
        Brett.print();
        System.out.println(Brett.getField(position));
        System.out.println(Brett.nFreeFields());
        System.out.println(Brett.validMoves());

        Position position1 = new Position(2,1);
        Brett.setField(position1, -1);
        Brett.print();
        System.out.println(Brett.getField(position1));
        System.out.println(Brett.nFreeFields());
        System.out.println(Brett.validMoves());


        Position position2 = new Position(1,1);
        Brett.setField(position2, 1);
        Brett.print();
        System.out.println(Brett.getField(position2));
        System.out.println(Brett.nFreeFields());
        System.out.println(Brett.validMoves());
        System.out.println(Brett.isGameWon());

        Position position3 = new Position(1,0);
        Brett.setField(position3,-1);
        Brett.print();
        System.out.println(Brett.getField(position3));
        System.out.println(Brett.nFreeFields());
        System.out.println(Brett.validMoves());
        System.out.println(Brett.isGameWon());
        int d = alphaBeta(Brett, -1);
        System.out.println(d);

        Position position4 = new Position(0,2);
        Brett.setField(position4, 1);
        Brett.print();
        System.out.println(Brett.getField(position4));
        System.out.println(Brett.nFreeFields());
        System.out.println(Brett.validMoves());
        Brett.isGameWon();
        System.out.println(Brett.isGameWon());

        Brett.undoMove(position);
        Brett.undoMove(position1);
        Brett.undoMove(position2);
        Brett.undoMove(position3);
        Brett.undoMove(position4);
        Brett.print();
        System.out.println(Brett.nFreeFields());
        System.out.println(Brett.validMoves());


    }

}

