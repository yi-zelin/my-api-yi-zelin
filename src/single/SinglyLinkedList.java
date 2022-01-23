package single;

public class SinglyLinkedList<T> {
    private Node first;
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
    private class Node<T> {
        T data;
        Node next;

        //构造函数
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(Node next, T data) {
            this.data = data;
            this.next = next;
        }
    }

    //返回索引处的地址
    private Node node(int index) {
        Node t = first;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        return t;
    }

    //检查位置的有效性
    private void checkIndex(int index){
        if (index < 0 | index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    //返回索引处data
    public T get(int index) {
        //检查有效性
        checkIndex(index);
        //索引地址与值
        Node<T> address = node(index);
        T data = address.data;
        return data;
    }

    //size
    public int size() {
        int i = 0;
        for (Node t = first; t != null; t = t.next) {
            i++;
        }
        return i;
    }

    //isEmpty
    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    //toString
    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        String stringList = "[";
        for (Node t = first; t != null; t = t.next) {
            if (t.next == null) {
                stringList += t.data + "]";
                break;
            }
            stringList += t.data + ", ";
        }
        return stringList.toString();
    }

    //替换对应的node
    public T set(int index, T item) {
        //检查有效性
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

    //末尾添加
    public void append (T item){
        Node t = new Node(item);
        //如果是第一个node
        if (isEmpty()){
            first = t;
        } else {
            //遍历得到末尾地址, 并将末尾指向新node
            node(size - 1).next = t;
        }
        size ++;
    }

    //删除
    public T remove(int index){
        T deleted = get(index);
        //headnode check
        if(index == 0){
            first = node(index).next;
        }else {
            //之前node.next指向之后node的地址
            node(index - 1).next = node(index).next;
        }
        size --;
        return deleted;
    }

    //分离指定的node, 返回该node的位置
    private T detach(int index){
        T t = get(index);
        node(index-1).next = null;
        size = size();
        return t;
    }

    //末尾添加, 以及检测是否添加成功
    public boolean add(T item){
        //排除第一个添加的情况
        if (isEmpty()){
            append(item);
            //检查是否添加成功 (核对地址)
            if (first != node(0)){
                return false;
            }
            return true;
        }else {
            //用核对末尾node地址的方式来确定是否添加成功
            Node preAddress = node(size - 2).next;
            append(item);
            Node afterAddress = node(size - 2).next;
            if (preAddress != afterAddress) {
                return true;
            }
        }
        return false;
    }

    //指定位置添加
    public void add(int index, T item){
        //被添加的node, 以及使他指向原来在该位置上的节点
        Node t = new Node(item);
        t.next = node(index);
        //headnode check
        if (index == 0){
            first = t;
        }else {
            node(index - 1).next = t;
        }
        size ++;
    }

    //指定位置之前添加
    private void insertBefore(int index, T item){
        checkIndex(index);
        add(index-1, item);
    }

}
