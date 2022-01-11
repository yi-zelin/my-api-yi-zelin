package modules;

/****************************************************************
 * This module implements recursive algorithms for array 
 * data structures with integer precision.  
 * 
 * Update these methods with the recursive versions discussed in 
 * the class slides or your online textbook.
 * 
 * The Methods CANNOT use any special methods from the Java API.
 ****************************************************************/

public class RModule {

    public static int binarySearch(int[] data, int target) {
        //TODO : COMPLETE BODY (SEE CLASS SLIDES) 
        return 0;
    }

    private static int binarySearch(int[] data, int target, int min, int max) {
        //TODO : COMPLETE BODY (SEE CLASS SLIDES) 
        return 0;
    }



    private static int[] getFirstHalf(int[] data) {
        //TODO : CREATE SMALLER DATA STRUCTURES
        return null;
    }
    
    private static int[] getSecondHalf(int[] data) {
        //TODO : CREATE SMALLER DATA STRUCTURES 
        return null;
    }



    private static void merge(int[] data, int[] left, int[] right) {
        //TODO : COMPLETE BODY 
    }
    
    public static void mergeSort(int[] data) {
        //TODO : COMPLETE BODY 
    }
    
    private static int partition(int[] data, int low, int high) {
        //TODO : define variables (be efficient)

        //TODO : pick middle element as pivot

        //TODO : while low numbers < pivot increment index

        //TODO : while high numbers > pivot decrement index

        //TODO : swap low and high numbers if in wrong partition

        return high;
    }


    public static void quickSort(int[] data) {
        //TODO : set  min and max indexes
    }


    private static void quickSort(int[] data, int min, int max) {
        //TODO : get middle partition index
        //TODO : sort low partition from min to middle partition index
        //TODO : sort high partition from middle partition index to max

        //BASE CASE : DO NOTHING when only one or zero values in partition.
    }


    public static void selectionSort(int[] data) {
        //TODO : COMPLETE BODY (SEE CLASS SLIDES) 
    }

    private static void selectionSort(int[] data, int start) {
        //TODO : COMPLETE BODY (SEE CLASS SLIDES) 
    }

    private static void swap(int[] data, int a, int b) {
        //TODO : COMPLETE BODY
    }

}
