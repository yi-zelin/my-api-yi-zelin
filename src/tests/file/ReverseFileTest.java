package tests.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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

    public static void read(String inputLocation, List<String> list) throws FileNotFoundException{
        //TODO: READ IN DATA FROM INPUT FILE LOCATION
        //TODO: REVERSE LINES
        //TODO: REVERSE WORDS
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{
        //TODO : WRITE TO OUTPUT FILE LOCATION
    }


    public static void main(String[] args) throws FileNotFoundException{
        String inputLocation    = "." + File.separator + "lab-02"
                                      + File.separator + "words.txt";
        String outputLocation   = "." + File.separator + "results"
                                      + File.separator + "reverse_words.txt";
        File file               = new File(inputLocation);
        Scanner input           = new Scanner(file);
        PrintStream output      = new PrintStream(outputLocation);

        //TODO: update program to use an Array List

        // TODO: process items in file

        input.close();
        output.close();
    }
}
