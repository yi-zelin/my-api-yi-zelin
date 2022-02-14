package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class TecTest {
    public static void main(String[] args) {
        Map<Integer,Integer> diagonal = new HashMap<>();
        diagonal.put(1,9);diagonal.put(9,1);diagonal.put(3,7);diagonal.put(7,3);
        System.out.println(diagonal.get(2));
    }
}
