package tests.console;

import java.util.Scanner;
import functions.F1;
import functions.F2;
import functions.F3;

public class FunctionTest {

//    public static double add(int x, int y){
//        return x + y;
//    }
//    public static double divide(int x, int y){
//        return y / x;
//    }
//    public static double multiply(int x, int y){
//        return x * y;
//    }
//    public static double subtract(int x, int y){
//        return x - y;
//    }


    public static void main(String[] args) {
//        testOperators( (x,y) -> (double) x + y, " A D D I T I O N \t x + y", "+" );
//        testOperators( (x,y) -> x - y , "S U B T R A C T I O N \t x - y" , "-");
//        testOperators( (x,y) -> x * y , "M U L T I P L I C A T I O N \t x * y", "*");
//        testOperators( (x,y) -> (double) y / x , "D I V I S I O N \t y / x", "/");
        testOperators(new F2() {
            @Override
            public double f(int x, int y) {
                return x+y;
            }
        }, " A D D I T I O N \t x + y", "+");
        testOperators(new F2() {
            @Override
            public double f(int x, int y) {
                return x-y;
            }
        }, "S U B T R A C T I O N \t x - y", "-");
        testOperators(new F2() {
            @Override
            public double f(int x, int y) {
                return x*y;
            }
        }, "M U L T I P L I C A T I O N \t x * y", "*");
        testOperators(new F2() {
            @Override
            public double f(int x, int y) {
                return y/x;
            }
        }, "D I V I S I O N \t y / x", "/");

        testVolumeOfCylinder(new F2() {
            @Override
            public double f(int r, int h) {
                return Math.PI * r * r * h;
            }
        });

        testVolumeOfBox(new F3() {
            @Override
            public double f(int l, int h, int w) {
                return l * w * h;
            }
        });

        testAreaOfCircle(new F1() {
            @Override
            public double f(int r) {
                return Math.PI * r * r;
            }
        });

        testVolumeOfSphere(new F1() {
            @Override
            public double f(int r) {
                return (double) (4 / 3) * Math.PI * r * r * r;
            }
        });
//        volumeCylinder( (r, h)-> Math.PI * r * r * h );
//
//        volumeBox( (l, w, h) -> l * w * h);
//
//        areaCircle( r -> Math.PI * r * r);
//
//        volumeSphere( r -> (double) (4 / 3) * Math.PI * r * r * r );
    }


    public static void testAreaOfCircle(F1 f){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a number for the radius of circle: ");
        int radius = scanner.nextInt();
        System.out.println();
        System.out.println("======== R E S U L T S==========");
        System.out.println();
        System.out.println("Area of circle is: "+f.f(radius));
        System.out.println();
        System.out.println("================================");
    }


    public static void testOperators(F2 f, String msg, String op){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("============= " + msg + " =============");

        System.out.print("Enter x  y: ");

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println();
        if (op.equals("/"))
            System.out.printf("%d %s %d = %.1f", y, op, x, f.f(x,y));
        else
            System.out.printf("%d %s %d = %.1f", x, op, y, f.f(x,y));

        System.out.println();
        System.out.println("==================================================");
    }


    public static void testVolumeOfBox(F3 f){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a number for the length of box: ");
        int l = scanner.nextInt();
        System.out.println("Pick a number for the height of box: ");
        int h = scanner.nextInt();
        System.out.println("Pick a number for the width of box: ");
        int w = scanner.nextInt();
        System.out.println();
        System.out.println("======== R E S U L T S==========");
        System.out.println();
        System.out.println("The volume of the box is: " + f.f(l, h, w));
        System.out.println();
        System.out.println("================================");
    }


    public static void testVolumeOfCylinder(F2 f){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a number for the radius of cylinder: ");
        int r = scanner.nextInt();
        System.out.println("Pick a number for the height of cylinder: ");
        int h = scanner.nextInt();
        System.out.println();
        System.out.println("======== R E S U L T S==========");
        System.out.println();
        System.out.println("Volume of cylinder is: "+ f.f(r, h));
        System.out.println();
        System.out.println("================================");
    }


    public static void testVolumeOfSphere(F1 f){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius of sphere: ");
        int radius = scanner.nextInt();
        System.out.println();
        System.out.println("======== R E S U L T S ==========");
        System.out.println();
        System.out.println("Volume of sphere is: "+ f.f(radius));
        System.out.println();
        System.out.println("==================================");
    }

}