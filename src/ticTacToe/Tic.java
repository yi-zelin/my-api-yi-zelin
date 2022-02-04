package ticTacToe;

public class Tic {
    public int[] player;
    public int[] pc;
    public int[] possible;
    public int steep;

    //构造函数 & 重启
    public Tic(){
        player = new int[5];
        pc = new int[5];
        possible = new int[9];
        steep = 0;
    }

    //添加棋子
    public void playerAdd(int t){
        player[t] = 1;
    }
    public void pc(int t){
        pc[t] = 1;
    }

    /**
     * 基本方法
     *      检测胜利
     *      检测是否有绝杀点或者被绝杀点, 如果有, 自动补点
     *      字典匹配不上且无关键点时, 随机下
     */
    public void ifwin(){

    }
}
