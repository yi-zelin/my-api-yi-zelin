package tests.console;

public class TravelDirectionTest {

    private static void goNorthEast(int endX, int endY, int x, int y, String route) {

        if (x == endX && y == endY) {
            System.out.println(route);

        }else if(x <= endX && y <= endY){
            goNorthEast(endX, endY,      x, y + 1, route + " N");
            goNorthEast(endX, endY,x + 1,       y, route + " E");
            goNorthEast(endX, endY,x + 1, y + 1, route + " NE");
        }

        //OTHERWISE : DO NOTHING
    }

    public static void goNorthEast(int endX, int endY, int startX, int startY) {
        goNorthEast(endX, endY, startX, startY, "moves:");
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t T R A V E L    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    private static void goBack(int endX, int endY, int x, int y, String route) {

        if (x == endX && y == endY) {
            System.out.println(route);

        }else if(x <= endX && y <= endY){
            goBack(endX, endY,      x, y + 1, route + " S");
            goBack(endX, endY,x + 1,       y, route + " W");
            goBack(endX, endY,x + 1, y + 1, route + " SW");
        }

        //OTHERWISE : DO NOTHING
    }

    public static void goBack(int startX, int startY, int endX, int endY) {
        goBack(startX, startY, endX, endY, "movesBack:");
    }

    public static void main(String[] args) {
        intro();
        System.out.println("Movement 1\n");
        goNorthEast(1,2, 0, 0);
        System.out.println("\n\nMovement 2\n");
        goNorthEast(1,2, 0, 0);
        System.out.println();
        goBack(1,2,0,0);
        System.out.println();
    }
}
