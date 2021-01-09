import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Stack;

import static java.lang.Math.abs;

public class Board {
    private int n;
    Character [][] Brett;
    int unusedItems;






    public Board(int n)
    {
        if (n>10|| n<1){
            throw new InputMismatchException("Die Feldgröße liegt nicht im Wertebereich !");
        }
        this.Brett   = new Character [n][n];
        this.n= n;
        this.unusedItems= n*n;
        for (int a= 0; a<Brett.length; a++){
            for (int b= 0; b<Brett[0].length; b++){
                Brett[a][b]= '0';
            }
            System.out.println();
        }
        // TODO
    }
    
    
    public int getN() {


        return n; }

    public int nFreeFields() {

        return this.unusedItems;

        // TODO
    }

    public int getField(Position pos) throws InputMismatchException
    {
        if (this.Brett [pos.x] [pos.y]== 'x') {

            return 1;
        }

        if (this.Brett [pos.x][pos.y]== 'o'){

            return -1;
        }
        if (this.Brett [pos.x][pos.y]== '0'){
            return 0;
        }

        throw new InputMismatchException();

        // TODO

    }

    public void setField(Position pos, int token) throws InputMismatchException
    {


        if (token==0) {
            this.Brett[pos.x][pos.y] = '0';
            this.unusedItems = this.unusedItems -1;
            return;
        }


            if (token == 1) {
                this.Brett[pos.x][pos.y] = 'x';
                this.unusedItems= this.unusedItems -1;
                return;
            }


            if (token == -1) {
                this.Brett[pos.x][pos.y] = 'o';
                this.unusedItems = this.unusedItems - 1;
                return;
            }


            throw new InputMismatchException();


        // TODO
    }

    public void doMove(Position pos, int player)
    {
        setField(pos, player);

        // TODO
    }

    public void undoMove(Position pos)
    {
        this.Brett [pos.x] [pos.y] = '0';
        this.unusedItems= this.unusedItems+1;

        // TODO
    }

    public boolean isGameWon() {

        int Zaehlerx = 0;
        int Zaehlery = 0;
        for (int i = 0; i < this.Brett.length; i++) {
           Zaehlerx=0;
           Zaehlery=0;
            for (int j = 0; j < this.Brett[0].length; j++) {
                if (Brett[i][j] == 'x') {
                    Zaehlerx++;
                }
                if (Brett[i][j] == 'o') {
                    Zaehlery++;
                }
                if (Zaehlery == this.n|| Zaehlerx == this.n) {
                    return true;
            }
        }

        }
        //Zaehlerx = 0;
       // Zaehlery = 0;
        for (int i = 0; i <this.Brett.length; i++) {
            Zaehlerx=0;
            Zaehlery=0;
            for (int j = 0; j < this.Brett[0].length; j++) {
                if (Brett[j][i] == 'x') {
                    Zaehlerx++;
                }
                if (Brett[j][i] == 'o') {
                    Zaehlery++;

                }
                if (Zaehlery == this.n || Zaehlerx == this.n) {
                    return true;
            }
        }

        }

        Zaehlerx=0;
        Zaehlery=0;
        for (int i=0; i<this.Brett.length; i++){
            if (Brett[i][i]== 'x'){
                Zaehlerx++;
            }
            if (Brett[i][i]== 'o'){
                Zaehlery++;
            }
            if (Zaehlery==this.n || Zaehlerx== this.n){
                return true;
            }
        }
        Zaehlerx=0;
        Zaehlery=0;

        for( int i=n-1,j=0 ;i<this.Brett.length && j<this.Brett.length;i--,j++){
          // Zaehlerx=0;
            //Zaehlery=0;
                if (Brett[i][j] == 'x') {
                    Zaehlerx++;
                }
                if (Brett[i][j] == 'o') {
                    Zaehlery++;
                }
                if (Zaehlery == this.n || Zaehlerx == this.n) {
                    return true;
                }


        }
        return false;

    }



    public Iterable<Position> validMoves()
    {
        LinkedList<Position> position = new LinkedList<>();
        for (int a= 0; a<Brett.length; a++){
            for (int b= 0; b<Brett[0].length; b++){
                if (Brett[b][a] == '0' ){
                    position.add(new Position(b, a));

                }
            }
        }
        return position;



        // TODO
   }

    public void print()
    {


        for (int a= 0; a<Brett.length; a++){
            for (int b= 0; b<Brett[0].length; b++){
                System.out.print(Brett[b][a]+ " ");
            }
            System.out.println();
        }

    }


}

