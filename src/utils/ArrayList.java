package utils;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 *****************************************************************/

public class ArrayList<E> {
    static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }
}
