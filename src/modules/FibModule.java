package modules;

import functions.Fib;

/****************************************************************
 * This module is included for the Fibonacci Recursion Exercise
 ****************************************************************/
public class FibModule {

    public static long fib(int n) {
        //TODO : COMPLETE BODY OF RECURSIVE METHOD
        if (n == 0){ return 0; }
        if (n == 1){ return 1; }
        return fib(n-1)+fib(n-2);
    }

    public static long ifib(int n) {
        //TODO : COMPLETE BODY OF ITERATIVE METHOD
        if (n <= 1){ return n; }
        long last = 1;
        long beforeLast = 0;
        long temp;
        for (int i = n; i >= 2; i--){
            temp = last;
            last = last + beforeLast;
            beforeLast = temp;
        }
        return last;
    }

    public static long mfib(int n) {
        //TODO : COMPLETE BODY OF MEMOIZATION METHOD
        int[] x = new int[3];
        x[1] = 1;
        x[2] = 1;
        return memo(n,x);
    }

    private static long memo(int n, int[] x) {
        //TODO : COMPLETE BODY OF MEMOIZATION HELPER METHOD
        if (n == 1){
            return x[2];
        }else if (n == 0){
            return 0;
        }

        x[2] = x[0] + x[1];
        x[0] = x[1];
        x[1] = x[2];
        return memo(n-1,x);
    }


    /****************************************************************
     * prints large value sequence in lines. This uses a functional
     * programming approach to print out the data.
     ****************************************************************/
    public static void largePrint(Fib f, int n){
        System.out.println("============ R E S U L T S  ============");
        System.out.println();
        System.out.println();
        System.out.println("====== Large Value Printing Ahead ====== ");
        System.out.println();
        //PRINTS : value for nth factorial
        System.out.println("\t \t n \t \t value");
        for (int i = 0; i <= n; i++ ) {
            String str1 = String.format("\t \t %d \t \t %d \n", i, f.fib(i));
            String str2 = String.format("\t \t %d \t %d \n", i, f.fib(i));

            //TERNARY OPERATOR
            String fString = (i < 10) ? str1 : str2;
            System.out.print(fString);
        }

        System.out.println();
    }


    /****************************************************************
     * prints nth Fibonacci. This uses a functional programming
     * approach to print out the data.
     ****************************************************************/
    public static void print(Fib f, int n){
        System.out.println("============== nth Fibonacci ============");

        // PRINTS : count of nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", i);
        }
        System.out.println();

        //PRINTS : value for nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", f.fib(i));
        }
        System.out.println();
    }

}
