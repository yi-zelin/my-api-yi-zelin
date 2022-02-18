package ticTacToe;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class dictionary extends Tic{
    private final int[] middle = {2,4,6,8};
    private final int[] corner = {1,3,7,9};
    private final int[] central = {5};
    private int formulaNumber;
    private int subFormulaNumber;
    private int lastPC;
    private int lastPlayer;
    private boolean needDictionary;

    /**
     * 步骤定义
     *  下对角线
     *  下对边
     *  下左下,右下,左上,右上
     *  下左边,右边,上边,下边
     */
    Map<Integer,Integer> diagonal = new HashMap<>();  //对角线
    Map<Integer,Integer> opposite = new HashMap<>();  //对边
    Map<Integer,int[]> together = new HashMap<>();  //相邻
    Map<Integer,int[]> close = new HashMap<>();  //相邻
    Map<Integer,int[]> far = new HashMap<>();  //相邻


    dictionary(){
        diagonal.put(1,9);diagonal.put(9,1);diagonal.put(3,7);diagonal.put(7,3);
        opposite.put(2,8);opposite.put(8,2);opposite.put(4,6);opposite.put(6,4);
        together.put(1,new int[] {2,4});together.put(2,new int[] {1,3,5});together.put(3,new int[] {2,6});
        together.put(4,new int[] {1,5,7});together.put(5,middle);together.put(6,new int[] {3,5,9});
        together.put(7,new int[] {4,8});together.put(8,new int[] {5,7,9});together.put(9,new int[] {6,8});
        close.put(1,central);close.put(2,new int[] {4,6});close.put(3,central);
        close.put(4,new int[] {2,8});close.put(5,corner);close.put(6,new int[] {2,8});
        close.put(7,central);close.put(8,new int[] {4,6});close.put(9,central);
        far.put(1,new int[] {3,7});far.put(3,new int[] {1,9});
        far.put(7,new int[] {1,9});far.put(9,new int[] {3,7});
        far.put(4,new int[] {3,9});far.put(6,new int[] {1,7});
        far.put(2,new int[] {7,9});far.put(8,new int[] {1,3});


        formulaNumber = 0;
        subFormulaNumber = 0;
        lastPC = 0;
        lastPlayer = 0;
        needDictionary = true;
    }

    /**
     * return 0 代表使用简单模式的通用代码
     */
    private int[] intListAdd(int[] list, int number){
        int[] temp = new int[list.length+1];
        System.arraycopy(list, 0, temp, 0, list.length);
        temp[list.length] = number;
        return temp;
    }

    private int[] intListAdd(int[] list1, int[] list2){
        int[] temp = new int[list1.length+list2.length];
        for (int i = 0; i < list1.length+list2.length+1; i++){
            if(i < list1.length){
                temp[i] = list1[i];
            }else {
                temp[i] = list2[i-list1.length];
            }
        }
        return temp;
    }

    private int inCommon(int[] list1,int[] list2){
        for (int i : list1){
            for (int t : list2){
                if (i == t){
                    return i;
                }
            }
        }
        return 0;
    }

    private boolean checkInclude(int[] positionList,int input){
        for (int i : positionList){
            if (i == input){ return true; }
        }
        return false;
    }

    public void setLast(int lastPC, int lastPlayer){
        this.lastPC = lastPC;
        this.lastPlayer = lastPlayer;
    }

    private int randomInList(int[] list){
        int i = (int) (Math.random() * (list.length));    // [0,max]
        return list[i];
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
        System.out.println("Error at playerFirst");
        System.exit(0);
        return 0;
    }

    //formulaNumber = 1
    private int PF_Formula1_Steep2(int input){
        // 1-1
        if (checkInclude(far.get(lastPC), input)){
            subFormulaNumber = 1;
            return 0;
        }
        // 1-2
        if (checkInclude(close.get(lastPC), input)){
            subFormulaNumber = 2;
            return inCommon(far.get(lastPC), far.get(lastPlayer));
        }
        // 1-3
        if (checkInclude(far.get(lastPlayer),input)){
            needDictionary = false;
            return randomInList(intListAdd(far.get(lastPC),inCommon(together.get(lastPlayer), close.get(lastPC))));
        }
        // 1-4
        if (input == 5){
            needDictionary = false;
            return randomInList(corner);
        }
        System.out.println("Error at PF_Formula1_Steep2");
        System.exit(0);
        return 0;
    }

    //formulaNumber = 2 , finish
    private int PF_Formula2_Steep2(int input){
        needDictionary = false;
        // 2-1-1
        if (input == diagonal.get(lastPC)){
            return randomInList(far.get(input));
        } else {
            // 2-1
            return 0;
        }
    }

    //formulaNumber = 3
    private int PF_Formula3_Steep2(int input){
        needDictionary = false;
        // 3-1.2
        if (diagonal.get(lastPlayer) == input){
            return randomInList(middle);
        }
        // 3-1.1
        if (checkInclude(together.get(diagonal.get(lastPlayer)),input)){
            return diagonal.get(lastPlayer);
        }
        return 0;
    }

    // finish
    private int PF_Formula1_1_Steep3(int input){
        needDictionary = false;
        //1-1-1.1
        if (input == 5){
            return 0;
        }
        //1-1-1.2
        if (checkInclude(together.get(lastPC), input)){
            return diagonal.get(lastPC);
        }
        return 0;
    }

    public int useDictionary(int input){
        return 0;
    }



}
