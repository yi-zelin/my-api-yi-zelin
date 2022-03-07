package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 *****************************************************************/

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    int size;
    //constructor
    public LinkedList (){
        first = null;
        last = null;
        size = 0;
    }

    //doubly linked node
    private static class Node<E>{
        E data;
        Node<E> prev;
        Node<E> next;
        //constructor

        /**
         * @param prev previous node
         * @param data data
         */
        public Node(Node<E> prev,E data){
            this.prev = prev;
            this.data = data;
        }

        /**
         * @param prev previous node
         * @param next next node
         * @param data data
         */
        public Node(Node<E> prev, Node<E> next, E data){
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    /**
     * add to end of node
     * @param item data to add
     * @return before node address != after node address
     */
    public boolean add(E item){
        Node<E> before = last;
        append(item);
        return before != last;
    }

    /**
     * add before index
     * @param index index of node
     * @param item data
     */
    public void add(int index, E item){
        insertBefore(index,item);
    }

    /**
     * appends elements to the end of the list
     * @param item data which will add to the end
     */
    public void append( E item){
        Node<E> t = new Node<>(last, item);
        if (isEmpty()){
            first = t;
        } else {
            node(size - 1).next = t;
        }
        last = t;
        size ++;
    }

    /**
     * checks if the given index is valid.
     * Throws an IndexOutOfBoundsException, if invalid
     * @param index the index of the node
     */
    private void checkIndex(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @param item to find
     * @return if include item
     */
    public boolean contains(E item){
        for (int t = 0; t < size; t++){
            if (get(t) == item){
                return true;
            }
        }
        return false;
    }

    /**
     * initialize first, last, size
     */
    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    /**
     * remove by index
     * @param index index of node
     * @return data of removed node
     */
    private E detach(int index){
        checkIndex(index);
        E removed = get(index);
        if (index == 0){
            //remove first
            first = first.next;
            node(0).prev = null;
        } else if (index == size - 1){
            //remove last
            node(index - 1).next = null;
        } else {
            node(index - 1).next = node(index + 1);
            node(index + 1).prev = node(index - 1);
        }
        size--;
        return removed;
    }

    /**
     * will check index validity first
     * get data of node at index
     * @param index the index of the node
     * @return data of node at index
     */
    public E get(int index){
        checkIndex(index);
        Node<E> t = node(index);
        return t.data;
    }

    /**
     *
     * @param item data to find
     * @return index of first mach or -1 if no mach
     */
    public int indexOf(E item){
        for (int t = 0; t < size; t++){
            if(get(t) == item){
                return t;
            }
        }
        return -1;
    }

    /**
     * add before index
     * @param index index of node
     * @param item data
     */
    private void insertBefore(int index, E item){
        checkIndex(index);
        Node<E> insertNode;
        if (index == size()) {
            append(item);
        } else if (index == 0) {
            insertNode = new Node<>(null, first, item);
            first.prev = insertNode;
            first = insertNode;
        } else {
            insertNode = new Node<>(node(index - 1), node(index), item);
            node(index - 1).next = insertNode;
            node(index + 1).prev = insertNode;
            size++;
        }
    }

    /**
     * @return if empty
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @param index index
     * @return Node at index
     */
    private Node<E> node(int index){
        // normal access
        Node<E> t;
        if (index <= size/2){
            t = first;
            for (int i = 0; i < index; i++){
                t = t.next;
            }
        } else {
            // reverse order access
            t = last;
            for (int i = 1; i < size - index; i++){
                t = t.prev;
            }
        }
        return t;
    }

    /**
     * remove by index
     * @param index index of node
     * @return data of removed node
     */
    public E remove(int index){
        return detach(index);
    }

    /**
     * remove by data, first match only
     * @param item data
     * @return true if it has match to remove
     */
    public boolean remove(E item){
        int t = indexOf(item);
        if (t != -1) {
            if (t == 0) {
                //remove first
                first = first.next;
                node(0).prev = null;
            } else if (t == size - 1) {
                //remove last
                node(t - 1).next = null;
            } else {
                node(t - 1).next = node(t + 1);
                node(t + 1).prev = node(t - 1);
            }
            size--;
            return true;
        }

        return false;
    }

    /**
     * check index validity first
     * replace data at index by item
     * @param index node index
     * @param item to replace
     * @return data was replaced
     */
    public E set(int index, E item){
        checkIndex(index);
        E beSet = get(index);
        node(index).data = item;
        return beSet;
    }

    /**
     * @return return size of node
     */
    public int size(){
        return size;
    }

    /**
     * to String
     * @return String of node
     */
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder stringList = new StringBuilder("[");
        for (Node<E> t = first; t != null; t = t.next) {
            if (t.next == null) {
                stringList.append(t.data).append("]");
                break;
            }
            stringList.append(t.data).append(", ");
        }
        return stringList.toString();
    }

    private class LinkedIterator implements Iterator<E> {
        int cursor;
        int lastRet = -1;

        LinkedIterator() {}

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
            return get(lastRet);
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            LinkedList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }

        public Iterator<E> iterator(){
            return new LinkedIterator();
        }
    }
}
