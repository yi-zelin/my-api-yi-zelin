package ticTacToe;

public class TecTest {
    public static void main(String[] args) {
        Tic i = new Tic();
        i.print();
        System.out.println("\n\n\n");
        i.playerAdd(1);
        i.pcAdd(2);
        i.print();
        String a = "\033[37;4mHello,Akina!\033[0m";
        System.out.println(a.isEmpty());
    }
}
