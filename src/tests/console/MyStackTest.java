package tests.console;

import utils.MyQueue;
import utils.MyStack;

import java.util.Stack;

public class MyStackTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("=====================================================");
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t S T A C K    T E S T    P R O G R A M");
        System.out.println();
        System.out.println("=====================================================");
        System.out.println();
        System.out.println();
    }


    public static void libraryVersionTest(){
        System.out.println();
        System.out.println("<------- \t L I B R A R Y \t\t S T A C K \t ------->");
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();

        System.out.println();
        System.out.println();

        //test push
        System.out.println("************\t Test push \t**************");
        System.out.println(stack.push("Red"));
        System.out.println(stack.push("Orange"));
        System.out.println(stack.push("Yellow"));
        System.out.println(stack.push("Green"));
        System.out.println(stack.push("Blue"));
        System.out.println(stack.push("Indigo"));
        System.out.println(stack.push("Violet"));
        System.out.println(stack);
        System.out.println();
        System.out.println();
        System.out.println();


        // test pop
        System.out.println("************\t Test pop \t**************");
        System.out.println();
        System.out.println("----------original-----------");
        System.out.println("size: " + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------1st pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------2nd pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------3rd pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------4th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------5th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------6th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------7th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println();

        //test peek
        System.out.println("************\t Test peek \t **************");
        stack1.push("Red");
        stack1.push("Orange");
        stack1.push("Yellow");
        System.out.println(stack1);
        System.out.println("peek element: " + stack1.peek());
        System.out.println();
        System.out.println();
    }


    public static void myVersionTest(){
        System.out.println();
        System.out.println("==========  M Y   S T A C K  ==========\n");
        MyStack<String> stack = new MyStack<>();
        MyQueue<String> queue = new MyQueue<>();
        stack.push("Red");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Green");
        stack.push("Blue");
        stack.push("Indigo");
        stack.push("Violet");
        System.out.println("Stack: "+stack);
        stackToQueue(stack,queue);
        System.out.println("After stackToQueue");
        System.out.println("Queue: "+queue);
        System.out.println("After queueToStack");
        queueToStack(queue,stack);
        System.out.println("Stack: "+stack);
        removeMinTest();
    }


    public static int removeMin(MyStack<Integer> stack){
        int size = stack.size();
        int[] list = new int[size];
        int min = stack.peek();
        for(int i = 0; i < size; i++){
            int temp = stack.pop();
            list[i] = temp;
            if (min > temp){
                min = temp;
            }
        }
        for(int i = size-1; i >= 0; i--){
            if (list[i] != min){
                stack.push(list[i]);
            }
        }
        return min;
    }


    public static void removeMinTest(){
        System.out.println();
        System.out.println("============  R E M O V E   M I N  =============\n");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(11);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(7);
        stack.push(12);
        stack.push(4);
        System.out.println("Before:  " + stack);
        System.out.println("Min_Int: " + removeMin(stack));
        System.out.println("After:   " + stack);

    }


    public static void queueToStack(MyQueue<String> queue,MyStack<String> stack){
        MyStack<String> temp = new MyStack<>();
        int size = queue.size();
        for (int i = 1; i<= size; i++) {
            temp.push(queue.remove());
        }
        for (int i = 1; i<= size; i++) {
            stack.push(temp.pop());
        }
    }


    public static void stackToQueue(MyStack<String> stack,MyQueue<String> queue){
        int size = stack.size();
        for (int i = 1; i<= size; i++) {
            queue.add(stack.pop());
        }
    }


    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
    }


}

