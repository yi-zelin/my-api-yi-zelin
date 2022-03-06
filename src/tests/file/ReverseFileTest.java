package tests.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseFileTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t  R  E  V  E  R  S  E    F  I  L  E    T  E  S  T");
        System.out.println(" \t \t      T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
    }

    public static List<String> read(String inputLocation) throws FileNotFoundException{
        //TODO: READ IN DATA FROM INPUT FILE LOCATION
        File file = new File(inputLocation);
        Scanner reader = new Scanner(file);

        String readLine;
        ArrayList<String> line = new ArrayList<>();
        while (reader.hasNextLine()){
            readLine = reader.nextLine();
            line.add(readLine);
        }
        // [Pear Grape Strawberry Banana Orange Apple Raspberry, , Six Five Four Two One, , Sam Tim Kim Bob Jim Bow]
        //TODO: REVERSE LINES
        ArrayList<String> reverseLine = new ArrayList<>();
        for (int i = line.size()-1; i >= 0; i--){
            reverseLine.add(line.get(i));
        }
        //[Sam Tim Kim Bob Jim Bow, , Six Five Four Two One, , Pear Grape Strawberry Banana  Orange Apple Raspberry]
        //TODO: REVERSE WORDS
        //ArrayList<String> reverseWord = new ArrayList<String>();
        for (int i = 0; i < reverseLine.size(); i++){
            String [] temp = reverseLine.get(i).split("\\s+");
            String [] temp1 = new String[temp.length];
            int a = 0;
            for (int t = temp.length-1; t >= 0; t--){
                temp1[a] = temp[t];
                a++;
            }
            StringBuilder temp2 = new StringBuilder();
            for (int t = 0; t < temp1.length; t++){
                if(t != temp1.length-1){
                    temp2.append(temp1[t]).append(" ");
                }else {
                    temp2.append(temp1[t]);
                }

            }
            reverseLine.set(i,temp2.toString());
        }
        return reverseLine;
        //[Bow Jim Bob Kim Tim Sam, , One Two Four Five Six, , Raspberry Apple Orange Banana Strawberry Grape Pear]
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{
        //TODO : WRITE TO OUTPUT FILE LOCATION
        File file = new File(outputLocation);
        PrintStream writer = new PrintStream(file);
        if (file.exists()) {
            for (String s : list) {
                writer.println(s);
            }
        }
        writer.close();
    }


    public static void main(String[] args) throws FileNotFoundException{
        String inputLocation    = "." + File.separator + "lab-02"
                                      + File.separator + "words.txt";
        String outputLocation   = "." + File.separator + "results"
                                      + File.separator + "reverse.txt";
        File file               = new File(inputLocation);
        Scanner input           = new Scanner(file);
        PrintStream output      = new PrintStream(outputLocation);
        // all need
        write(outputLocation,read(inputLocation));

        //TODO: update program to use an Array List

        // TODO: process items in file

        input.close();
        output.close();
    }
}
