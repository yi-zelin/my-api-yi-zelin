package ticTacToe;


import java.util.Objects;
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
                 *                           *
                 *****************************

                \s""");
        String difficulty = scan.nextLine();
        if(Objects.equals(difficulty, "1")){
            hardMod = false;
        }else if(Objects.equals(difficulty, "2")){
            hardMod = true;
        }
        System.out.println("******** invalid input ********\n\n");
        System.exit(0);
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
        }
    }

    private void playerRound(){
        System.out.println("input your point [1 ~ 9]");
        String t = scan.nextLine();
        playerAdd(inputCheck(t));
        ifFinish();
    }

    private boolean headsOrTails(){
        Random random = new Random();
        System.out.println("******- Heads Or Tails -*******");
        // tossing
        System.out.print("tossing ");
        try {
            Thread.sleep(400);
            System.out.print(". ");
            Thread.sleep(400);
            System.out.print(". ");
            Thread.sleep(400);
            System.out.println(". ");
            Thread.sleep(400);
            System.out.println("guess! 0 for head 1 for tail");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // input
        String t = scan.nextLine();
        try {
            Integer.parseInt(t);
        } catch (NumberFormatException e){
            System.out.println("""


                    \033[31;4mplease input 0 or 1\033[0m""");
        }
        int intInput = Integer.parseInt(t);
            return intInput == random.nextInt(2);
    }

    private void startGame(){
        new iO();
        startPage();
        if(headsOrTails()){ playerRound(); }
        while (steep <= 9){
            ezPcRound();
            playerRound();
        }
    }


    public static void main(String[] args) {
        new iO().headsOrTails();
        //new iO().inputCheck("11111111111111111");
    }
}
