package modules;

import java.util.List;
import java.util.Comparator;

/*************************************************************
 * Update the following methods with the correct generic form
 * discussed in Algorithms Lab Advanced Exercise.
 *************************************************************/

public class TModule {

    /*************************************************************
     * Iterative Implementation of BinarySearch.
     *************************************************************/
    public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
        return 0;
    }

    /*************************************************************
     * Recursive Implementation of QuickSort with Comparable.
     *************************************************************/
    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        //TODO: COMPLETE BODY
        return high;
    }

    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        //TODO: COMPLETE BODY
    }

    private static <T extends Comparable<T>> void quickSort(List<T> list, int min, int max) {
        //TODO: COMPLETE BODY
    }

    /*************************************************************
     * Recursive Implementation of QuickSort with Comparator.
     *************************************************************/
    private static <T> int partition(List<T> list, int low, int high, Comparator<T> comp) {
        //TODO: COMPLETE BODY
        return high;
    }

    public static <T> void sort(List<T> list, Comparator<T> comp) {
        //TODO: COMPLETE BODY
    }

    private static <T> void sort(List<T> list, int min, int max, Comparator<T> comp) {
        //TODO: COMPLETE BODY
    }

    /*************************************************************
     * Swaps through finding indexes.
     *************************************************************/
    public static <T> void swap(List<T> list, int a, int b) {
        //TODO: COMPLETE BODY
    }

}
