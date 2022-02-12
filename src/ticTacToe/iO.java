package ticTacToe;

import java.util.Objects;
import java.util.Scanner;

public class iO extends Tic{
    public Tic a;
    public Scanner scan;
    public boolean restart;
    public String result;

    private iO(){
        a = new Tic();
        scan = new Scanner(System.in);
        restart = true;
        result = "";
    }


    private void startPage(){
        System.out.println("""
                 *****************************
                 *                           *
                 *   Welcome to Tic Tac Toe  *
                 *                           *
                 *   Choose Difficulty:      *
                 *   1 easy                  *
                 *   2 hard                  *
                 *                           *
                 *****************************

                \s""");
        String difficulty = scan.nextLine();
        if(Objects.equals(difficulty, "1")){
            a.hardMod = false;
        }else if(Objects.equals(difficulty, "2")){
            a.hardMod = true;
        }
        System.out.println("******** invalid input ********\n\n");
        System.exit(0);
    }

    private void ifwin(){
        if (a.checkwin(player)) { result = " *          You Win!         *"; } //player win
        if (a.checkwin(pc)) { result = " *          You Lost         *"; }    //pc win
        if (steep == 9) { result = " *         It's a tie        *"; }         //tie
    }

    private void end(int result){
        System.out.println("""
                 *****************************
                 *                           *
                 *          Finished         *
                 *                           *
                """+ result + """
                 *                           *
                 *         Q to quit         *
                 *   else key to play again  *
                 *                           *
                 *****************************
                """);
        String t = scan.nextLine();
        if (Objects.equals(t, "Q") | Objects.equals(t, "q")){
            System.exit(0);
        }
        startGame();
    }


    private void startGame(){
        new iO();
        startPage();
    }

    public void main(String[] args) {
            startGame();
    }
}
