package utils;


import java.util.NoSuchElementException;

public class MyQueue<E> {
    Node first;
    Node last;
    int size;

    //构造函数
    public MyQueue(){
        first = null;
        last = null;
        size = 0;
    }

    static class Node<E> {
        E data;
        Node next;

        //构造函数
        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(Node next, E data) {
            this.data = data;
            this.next = next;
        }
    }

    private void append(E item){
        Node t = new Node(last.next,item);
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
        E t = (E) first.data;
        if(size == 0){
            throw new NoSuchElementException();
        }
        detach();
        return t;
    }

    public E peek(){
        E t =(E) first.data;
        return t;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }
}
