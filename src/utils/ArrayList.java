package utils;

import java.util.NoSuchElementException;

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
        if(size == 0){
            add(item);
        }else {
            shiftRight(index);
            data[index] = item;
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    public void clear(){
        data =(E[]) new Object[data.length];
        size = 0;
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
            System.arraycopy(data, 0, temp, 0, data.length);
            this.data = temp;
        }
    }

    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E item){
        for(int i = 0; i < size; i++) {
            if (data[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E remove(int index){
        E temp = get(index);
        shiftLeft(index);
        return temp;
    }

    public boolean remove(E item){
        int temp = indexOf(item);
        if(temp == -1){
            return false;
        }
        remove(temp);
        return true;
    }

    public E set(int index, E item){
        checkIndex(index);
        E temp = data[index];
        data[index] = item;
        return temp;
    }

    private void shiftLeft(int index){
        for (int i = index; data[i] != null; i++) {
            data[i] = data[i+1];
        }
        size --;
    }

    private void shiftRight(int index){
        ensureCapacity(data.length);
        // latter = former
        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = null;
        size ++;
    }

    public int size(){
        return size;
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder toString = new StringBuilder("[");
        for(int i = 0; data[i] != null; i++){
            if(data[i+1] == null){
                toString.append(data[i]).append("]");
            }else {
                toString.append(data[i]).append(", ");
            }
        }
        return toString.toString();
    }

    private class ArrayIterator implements Iterator<E> {
        int cursor;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (cursor >= size){
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            cursor++;
            return data[lastRet];
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            ArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }

        public Iterator<E> iterator(){
            return new ArrayIterator();
        }
    }

}
