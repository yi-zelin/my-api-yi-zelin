package tests.console;

import modules.RModule;

import java.util.Arrays;
import static modules.IModule.binarySearch;
import static modules.IModule.bubbleSort;
import static modules.IModule.contains;
import static modules.IModule.indexOf;
import static modules.IModule.insertionSort;
import static modules.IModule.selectionSort;
import static modules.RModule.mergeSort;
import static modules.RModule.quickSort;

public class AlgorithmsTest {

    public static void checkBinarySearch(int[] data){
        System.out.println();
        System.out.println(" ========= B I N A R Y    S E A R C H =========");
        System.out.println();
        System.out.println("location of 2: " + binarySearch(data, 2));
        System.out.println("location of 5: " + binarySearch(data, 7));
        System.out.println("location of 9: " + binarySearch(data, 9));
        System.out.println();
    }


    public static void checkBubbleSort(int[] data) {
        System.out.println(" ========= B U B B L E   S O R T =========");
        System.out.println();
        System.out.println(Arrays.toString(data));
        bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }


    public static void checkInsertionSort(int[] data) {
        System.out.println(" ========= I N S E R T I O N   S O R T =========");
        System.out.println();
        System.out.println(Arrays.toString(data));
        insertionSort(data);
        System.out.println(Arrays.toString(data));
    }


    public static void checkMergeSort(int[] data) {
        System.out.println(" ========= M E R G E    S O R T =========");
        System.out.println();
        System.out.println(Arrays.toString(data));
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }


    public static void checkQuickSort(int[] data) {
        System.out.println(" ========= Q U I C K    S O R T =========");
        System.out.println();
        System.out.println(Arrays.toString(data));
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }


    public static void checkRecursiveBinarySearch(int[] data){
        System.out.println();
        System.out.println(" ===== R E C U R S I V E   B I N A R Y   S E A R C H =====");
        System.out.println();
        System.out.println("location of 2: " + RModule.binarySearch(data, 2));
        System.out.println("location of 7: " + RModule.binarySearch(data, 7));
        System.out.println("location of 9: " + RModule.binarySearch(data, 9));
        System.out.println();
    }


    public static void checkRecursiveSelectionSort(int[] data){
        System.out.println(" ========= R E C U R S I V E   S E L E C T I O N   S O R T =========");
        System.out.println(Arrays.toString(data));
        RModule.selectionSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();
    }


    public static void checkSelectionSort(int[] data){
        System.out.println(" ========= S E L E C T I O N    S O R T =========");
        System.out.println(Arrays.toString(data));
        selectionSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println();
    }


    public static void checkSequentialSearch(int[] data){
        System.out.println(" ========= S E L E C T I O N    S O R T =========");
        System.out.println();
        System.out.println("----------- indexOf ------------");
        System.out.println("location of 3: " + indexOf(data, 3));
        System.out.println("location of 7: " + indexOf(data, 7));
        System.out.println("location of 8: " + indexOf(data, 8));
        System.out.println();
        System.out.println("----------- contains ------------");
        System.out.println("location of 3: " + contains(data, 3));
        System.out.println("location of 7: " + contains(data, 7));
        System.out.println("location of 8: " + contains(data, 8));
        System.out.println();
    }


    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" A L G O R I T H M S    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        int[] data  = {2, 9, 4, 1, 7, 5, 3, 8, 6};
        int[] data1 = {2, 5, 7, 1, 4, 3, 6};
        int[] data2 = {1, 2, 4, 5, 6, 8, 9};
        int[] data3 = {2, 5, 11, 1, 9, 4, 16, 8, 13};

        checkBinarySearch(data2);

        // Using an anonymous array
        checkBinarySearch(new int[] {1, 2, 4, 5, 6, 8, 9});

        checkSelectionSort(data);

        // Using an anonymous array
        checkSelectionSort(new int[] {2, 9, 4, 1, 7, 5, 3, 8, 6});
    }

}
