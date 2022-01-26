package utils;

import java.util.EmptyStackException;

public class MyStack<E> {
    public Node<E> first;
    public Node<E> last;
    int size;

    //构造函数
    public MyStack() {
        first = null;
        last = null;
        size = 0;
    }

    static class Node<E>{
        E data;
        Node<E> next;

        //构造函数
        public Node(Node<E> next, E data) {
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
        Node<E> t = new Node<>(last,item);
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
        E t = last.data;
        //移除并替换第一个元素
        detach();
        return t;
    }

    public E peek(){
        //检查堆栈
        if(size == 0){
            throw new EmptyStackException();
        }
        return last.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

}
