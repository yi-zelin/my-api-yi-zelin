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

    }

    private void append(E item){
        Node<E> t = new Node<>(item);
        //是否为第一个
        if(size == 0){
            first = t;
        }else{
            last.next = t;
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
        if(size <= 2){
            last = first;
        }
        size --;
    }

    public E remove(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        E t = first.data;
        detach();
        return t;
    }

    public E peek(){
        if(size == 0){ return null; }
        return first.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder stringList = new StringBuilder("[");
        for (MyQueue.Node<E> t = first; t != null; t = t.next) {
            if (t.next == null) {
                stringList.append(t.data).append("]");
                break;
            }
            stringList.append(t.data).append(", ");
        }
        return stringList.toString();
    }
}
