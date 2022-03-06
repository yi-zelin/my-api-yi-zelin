package modules;

public class RecModule {

    public static int fac(int n) {
        //TODO: COMPLETE BODY
        if (n == 0){ return 1; }
        return n * (fac(n-1));
    }

    public static boolean isPalindrome(String s) {
        //TODO : COMPLETE BODY
        if (s.length() <= 1){ return true; }
        if (s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1,s.length()-1));
        }
        return false;
    }

    public static double pow(double x, int n) {
        //TODO: COMPLETE BODY
        if (n == 0 ){ return 1; }
        return x * pow(x,n-1);
    }

    public static int sum(int n) {
        //TODO : COMPLETE BODY
        if (n == 0 ){ return 0; }
        return n + sum(n-1);
    }

}
