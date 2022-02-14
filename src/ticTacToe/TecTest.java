package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class TecTest {
    public static void main(String[] args) {
        final Map<Integer,Integer> diagonal = new HashMap<>();
        diagonal.put(1,2);diagonal.put(2,1);
        System.out.println(diagonal.get(1));
        System.out.println(diagonal.get(2));
    }
}
