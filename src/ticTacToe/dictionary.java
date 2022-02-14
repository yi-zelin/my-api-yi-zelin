package ticTacToe;


import java.util.HashMap;
import java.util.Map;

public class dictionary extends Tic{
    private final int[] middle = {2,4,6,8};
    private final int[] corner = {1,3,7,9};
    private final int[] upCorner = {1,3};
    private final int[] downCorner = {7,9};
    private final int[] central = {5};
    private int formulaNumber;

    /**
     * 步骤定义
     *  下对角线
     *  下对边
     *  下左下,右下,左上,右上
     *  下左边,右边,上边,下边
     */
    Map<Integer,Integer> diagonal = new HashMap<>();  //对角线
    Map<Integer,Integer> opposite = new HashMap<>();  //对边
    Map<Integer,Integer> left = new HashMap<>();      //左
    Map<Integer,Integer> right = new HashMap<>();     //右
    Map<Integer,Integer> up = new HashMap<>();        //上
    Map<Integer,Integer> down = new HashMap<>();      //下
    Map<Integer,Integer> leftUp = new HashMap<>();    //左上
    Map<Integer,Integer> leftDown = new HashMap<>();  //左下
    Map<Integer,Integer> rightUp = new HashMap<>();   //右上
    Map<Integer,Integer> rightDown = new HashMap<>(); //右下
    Map<Integer,Integer> middleDiagonal1 = new HashMap<>(); //目对角
    Map<Integer,Integer> middleDiagonal2 = new HashMap<>();

    dictionary(){
        diagonal.put(1,9);diagonal.put(9,1);diagonal.put(3,7);diagonal.put(7,3);
        opposite.put(2,8);opposite.put(8,2);opposite.put(4,6);opposite.put(6,4);
        left.put(2,1);left.put(3,2);left.put(5,4);left.put(6,5);left.put(8,7);left.put(9,8);
        right.put(1,2);right.put(2,3);right.put(4,5);right.put(5,6);right.put(7,8);right.put(8,9);
        up.put(4,1);up.put(5,2);up.put(6,3);up.put(7,4);up.put(8,5);up.put(9,6);
        down.put(1,4);down.put(2,5);down.put(3,6);down.put(4,7);down.put(5,8);down.put(6,9);
        leftUp.put(5,1);leftUp.put(6,2);leftUp.put(8,4);leftUp.put(9,5);
        leftDown.put(2,4);leftDown.put(3,5);leftDown.put(5,7);leftDown.put(6,8);
        rightUp.put(4,2);rightUp.put(5,3);rightUp.put(7,5);rightUp.put(8,6);
        rightDown.put(1,5);rightDown.put(2,6);rightDown.put(4,8);rightDown.put(5,9);
        middleDiagonal1.put(1,6);middleDiagonal1.put(6,1);middleDiagonal1.put(3,4);middleDiagonal1.put(4,3);
        middleDiagonal2.put(4,9);middleDiagonal2.put(9,4);middleDiagonal2.put(6,7);middleDiagonal2.put(7,6);


        formulaNumber = 0;
    }

    private boolean checkInclude(int[] positionList,int input){
        for (int i : positionList){
            if (i == input){ return true; }
        }
        return false;
    }

    private int randomInList(int[] list){
        int i = (int) (Math.random() * (4));    //[0,3]
        return list[1];
    }

    private int playerFirst(int input){
        if (checkInclude(middle,input)){
            formulaNumber = 1;
            return opposite.get(input);
        }
        if (checkInclude(central,input)){
            formulaNumber = 2;
            return randomInList(corner);
        }
        if (checkInclude(corner,input)){
            formulaNumber = 3;
            return 5;
        }
        return 1;
    }

    private int PF_Steep2(int input){
        if (formulaNumber == 1){
            return 0;
        }
        if (formulaNumber == 2){

        }
        return 0;
    }


}
