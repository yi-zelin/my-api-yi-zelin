package single;

public class SinglyLinkedList<T> {
    private Node<T> first;
    int size;
    //构造函数
    public SinglyLinkedList (){
        first = null;
        size = 0;
    }


    /**
     * 定义Node class
     * @param <T>
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        //构造函数
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(Node<T> next, T data) {
            this.data = data;
            this.next = next;
        }
    }

    private void checkIndex(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<T> node(int index){
        Node<T> t = first;
        for (int i = 0; i < index; i++){
            t = t.next;
        }
        return t;
    }

    public T get(int index){
        checkIndex(index);
        Node<T> address = node(index);
        return address.data;
    }

    private T detach(int index){
        T deleted = get(index);
        if(index == 0){
            first = node(index).next;
        }else{
            node(index - 1).next = node(index).next;
        }
        size --;
        return deleted;
    }

    private void insertBefore(int index, T item){
        checkIndex(index);
        Node<T> t = new Node<>(node(index),item);
        if (index == 0){
            first = t;
        }else{
            node(index - 1).next = t;
        }
        size ++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void append(T item){
        Node<T> t = new Node<>(item);
        if (isEmpty()){
            first = t;
        } else {
            node(size - 1).next = t;
        }
        size ++;
    }

    public boolean add(T item){
        append(item);
        return true;
    }

    public void add(int index, T item){
        insertBefore(index,item);
    }

    public T remove(int index){
        return detach(index);
    }

    public T set(int index,T item){
        checkIndex(index);
        Node<T> address = node(index);
        T replaced = address.data;
        address.data = item;
        //检查是否是headnode
        if (index == 0){
            first = address;
        }
        return replaced;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        StringBuilder stringList = new StringBuilder("[");
        for (Node<T> t = first; t != null; t = t.next) {
            if (t.next == null) {
                stringList.append(t.data).append("]");
                break;
            }
            stringList.append(t.data).append(", ");
        }
        return stringList.toString();
    }
}
