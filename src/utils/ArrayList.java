package utils;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 *****************************************************************/

public class ArrayList<E> {
    static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] data;

    //空参构造.
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }


    public boolean add(E item){
        int oldSize = size;
        //capacity check
        ensureCapacity(data.length);
        //add item
        data[size] = item;
        size ++;
        return size == oldSize + 1;
    }

    public void add(int index, E item){
        //capacity check
        ensureCapacity(data.length);

        shiftRight(index);
        data[index] = item;
        size ++;
    }

    private void checkIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear(){
        data =(E[]) new Object[data.length];
    }

    public boolean contains(E item){
        for(int i = 0; i < size; i++){
            if(data[i] == item){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity){
        if (size == capacity) {
            E[] temp = (E[]) new Object[data.length + DEFAULT_CAPACITY];
            //clone data
            for (int i = 0; i <= data.length; i++) {
                temp[i] = data[i];
            }
            this.data = temp;
        }
    }

    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E item){
        //what is this? can't understand the description on canvas
        return 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E remove(int index){
        return null;
    }

    public boolean remove(E item){
        return true;
    }

    public E set(int index, E item){
        return null;
    }

    private void shiftLeft(int index){

    }

    private void shiftRight(int index){
        ensureCapacity(data.length);
        index -= data.length;
        // latter = former
        for (int i = -1; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = null;
    }

    public int size(){
        return size;
    }

    public String toString(){
        return "";
    }
}
