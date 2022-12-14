package ticTacToe;

import java.util.Random;

public class Tic {
    public boolean[] player;
    public boolean[] pc;
    public boolean[] emptyPoint;
    public int steep;
    public final int[][] checklist = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    public int dangerPoint;
    public int pcLast; //1 ~ 9

    //构造函数 & 重启
    public Tic(){
        player = new boolean[9];
        pc = new boolean[9];
        emptyPoint = new boolean[]{true, true, true, true, true, true, true, true, true};
        steep = 0;
        dangerPoint = -1;
    }

    //添加棋子
    public void playerAdd(int t){
        player[t-1] = true;
        emptyPoint[t-1] = false;
        steep ++;
        print();
    }
    public void pcAdd(int t){
        pcLast = t;
        pc[t-1] = true;
        emptyPoint[t-1] = false;
        steep ++;
        print();
    }

    /**
     * 基本方法
     *    *  检测胜利
     *    *  检测是否有绝杀点或者被绝杀点, 如果有, 自动补点
     *    *  字典匹配不上且无关键点时, 随机下
     */
    private boolean contains(boolean[] list, int input){
        return list[input-1];
    }

    public boolean checkWin(boolean[] list){
        for (int[] ints : checklist) {
            if (contains(list, ints[0]) &&
                    contains(list, ints[1]) &&
                    contains(list, ints[2])) {
                return true;
            }
        }
        return false;
    }



    private int boolToIntPositive(boolean input){
        return input ? 1 : 0;
    }
    private int boolToIntNegative(boolean input){
        return input ? -1 : 0;
    }

    /**
     * 检测是否有绝杀点或者被绝杀点
     * 如果有, 返回该点的值
     * 如果没有, 返回 0
     */
    public boolean dangerOrWinPoint(){
        boolean station = false;
        for (int[] ints : checklist) {
            int temp = boolToIntPositive(contains(pc, ints[0])) +
                    boolToIntPositive(contains(pc, ints[1])) +
                    boolToIntPositive(contains(pc, ints[2]))+
                    boolToIntNegative(contains(player, ints[0])) +
                    boolToIntNegative(contains(player, ints[1])) +
                    boolToIntNegative(contains(player, ints[2]));
            // 2 为 pc 有绝杀点
            if (temp == 2 | temp == -2) {
                // 返回该空白点坐标
                for (int t = 0; t < 3; t++) {
                    if (!contains(pc, ints[t]) && temp == 2) {
                        dangerPoint = ints[t];
                        return true;
                    }else if(!contains(player, ints[t]) && temp == -2){
                        dangerPoint = ints[t];
                        station = true;
                    }
                }
            }
        }
        return station;
    }

    //随机返回空点位
    public int randomEmptyPoint(){
        int randomRange = 0;
        int[] tempEmptyPosition = new int[9];
        Random random = new Random();
        //将所有空点位的位置复制到tempEmptyPosition [0-8]
        for(int i = 0; i < 9; i++){
            if(emptyPoint[i]){
                tempEmptyPosition[randomRange] = i;
                randomRange++;
            }
        }
        // 取随机点
        return tempEmptyPosition[random.nextInt(randomRange)]+1;
    }


    /**
     *
     * o for player
     * × for pc
     */
    public void print(){
        String[] printList = {"1","2","3","4","5","6","7","8","9"};
        for(int i = 0; i <= 8; i++){
            if(!emptyPoint[i]){
                if(player[i]){
                    printList[i] = "\033[32;4mo\033[0m";
                }else {
                    printList[i] = "\033[36;4m×\033[0m";
                }
            }
        }
        System.out.println(" "+printList[0]+" │ "+printList[1]+" │ "+printList[2]+" ");
        System.out.println("───┼───┼───");
        System.out.println(" "+printList[3]+" │ "+printList[4]+" │ "+printList[5]+" ");
        System.out.println("───┼───┼───");
        System.out.println(" "+printList[6]+" │ "+printList[7]+" │ "+printList[8]+"\n");
    }


}

