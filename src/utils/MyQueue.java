package utils;


import java.util.NoSuchElementException;

public class MyQueue<E> {
    public Node<E> first;
    public Node<E> last;
    int size;

    //构造函数
    public MyQueue(){
        first = null;
        last = null;
        size = 0;
    }

    static class Node<E> {
        E data;
        Node<E> next;

        //构造函数
        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(Node<E> next, E data) {
            this.data = data;
            this.next = next;
        }
    }

    private void append(E item){
        Node<E> t = new Node<>(item);
        //是否为第一个
        if(size == 0){
            first = t;
        }
        last = t;
        size ++;
    }

    public boolean add(E item){
        append(item);
        return true;
    }

    private void detach(){
        first = first.next;
        if(size == 1){
            last = first;
        }
        size --;
    }

    public E remove(){
        E t = first.data;
        if(size == 0){
            throw new NoSuchElementException();
        }
        detach();
        return t;
    }

    public E peek(){
        return first.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
