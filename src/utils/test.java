package utils;

public class test {
    public static void main(String[] args) {
        MyStack stack = new MyStack<>();
        stack.push(66);
        stack.push(12);
        stack.push(78);
        stack.push(56);
        stack.push(34);
        stack.push(43);
        stack.pop();
        stack.pop();
        System.out.print(stack.peek());
        stack.pop();
        System.out.print(stack.peek());
    }
}
