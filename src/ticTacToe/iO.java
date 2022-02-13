package ticTacToe;


import java.util.Scanner;
import java.util.Random;

public class iO extends Tic{
    public Tic a;
    public Scanner scan;
    public boolean restart;
    public String result;
    public boolean hardMod;

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
                 *   2 hard (unavailable yet)*
                 *   Else key to quit        *
                 *                           *
                 *****************************""");
        String i = scan.nextLine();
        if(i.equals("1")){
            hardMod = false;
        }else if(i.equals("2")) {
            hardMod = true;
        }else {System.exit(0);}
    }

    private void ifFinish(){
        if (a.checkWin(player)) {
            result = " *          You Win!         *";
            end(result);
        }
        if (a.checkWin(pc)) {
            result = " *          You Lost         *";
            end(result);
        }
        if (steep == 9) {
            result = " *         It's a tie        *";
            end(result);
        }
    }

    private void end(String result){
        System.out.println("""
                 *****************************
                 *                           *
                 *           Finish          *
                 *                           *
                """+ result + """
                 
                 *                           *
                 *         Q to quit         *
                 *   else key to play again  *
                 *                           *
                 *****************************
                """);
        String t = scan.nextLine();
        if (t.equals("Q") | t.equals("q")){
            System.exit(0);
        }
        startGame();
    }

    private int inputCheck(String input){
        try {
            if (input.isEmpty()) {
                System.out.println("""


                    \033[31;4myou inputted noting! \033[0m""");
            }
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("""


                    \033[31;4myour input should be a number between [1 ~ 9]\033[0m""");
            playerRound();
        }
        int intInput = Integer.parseInt(input);
        if (intInput <= 0 || intInput >= 10){
        System.out.println("""


                \033[31;4minput out of range, your input should be [1 ~ 9]\033[0m""");
        playerRound();
        }
        if (!emptyPoint[intInput-1]){
            System.out.println("""


                    \033[31;4There is already a pawn there, please choose another point\033[0m""");
            playerRound();
        }
        return intInput;
    }

    private void ezPcRound(){
        if (dangerOrWinPoint()){
            pcAdd(dangerPoint);
            ifFinish();
        } else {
            pcAdd(randomEmptyPoint());
            ifFinish();
        }
    }

    private void playerRound(){
        System.out.println("input your point [1 ~ 9]");
        String t = scan.nextLine();
        playerAdd(inputCheck(t));
        ifFinish();
    }

    private  String input(){
        String t = scan.nextLine();
        if (!t.equals("0") & !t.equals("1")){
            System.out.println("""

                    \033[31;4mplease input 0 or 1\033[0m
                    guess! 0 for head 1 for tail""");
            input();
        }
        return t;
    }

    private boolean headsOrTails(){
        Random random = new Random();
        System.out.println("******- Heads Or Tails -*******");
        // tossing
        System.out.print("tossing ");
        try {
            Thread.sleep(500);
            System.out.print(". ");
            Thread.sleep(500);
            System.out.print(". ");
            Thread.sleep(500);
            System.out.println(". ");
            Thread.sleep(500);
            System.out.println("guess! 0 for head 1 for tail");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input().equals(""+random.nextInt(2));
    }

    private void startGame(){
        startPage();
        if(headsOrTails()){
            System.out.println("you got it, you go first");
            print();
            playerRound();
        }
        System.out.println("you missed, pc go first");
        while (steep <= 9){
            ezPcRound();
            playerRound();
        }
    }


    public static void main(String[] args) {
        new iO().startGame();
    }
}
