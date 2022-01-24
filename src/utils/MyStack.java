package utils;

import java.util.EmptyStackException;

public class MyStack<E> {
    Node first;
    Node last;
    int size;

    //构造函数
    public MyStack() {
        first = null;
        last = null;
        size = 0;
    }

    static class Node<E>{
        E data;
        Node next;

        //构造函数
        public Node(Node next, E data) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 方法实现
     */
    private void detach(){
        //如果只有一个元素
        if(size == 1){
            first = null;
        }
        last = last.next;
        size --;
    }

    public E push(E item){
        Node t = new Node(last,item);
        last = t;
        if(size == 0){
            first = t;
        }
        size++;
        return item;
    }

    public E pop(){
        //检查堆栈
        if(size == 0){
            throw new EmptyStackException();
        }
        E t = (E) last.data;
        //移除并替换第一个元素
        detach();
        return t;
    }

    public E peek(){
        //检查堆栈
        if(size == 0){
            throw new EmptyStackException();
        }
        return (E) last.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        return false;
    }

}
