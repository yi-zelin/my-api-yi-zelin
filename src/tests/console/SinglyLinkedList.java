package tests.console;

public class SinglyLinkedList {
    public static void main(String[] args) {

        single.SinglyLinkedList<Integer> a = new single.SinglyLinkedList<>();
        System.out.println("\n********** add,append,toString test **********");
        System.out.println(a);
        System.out.println(a.add(100));
        System.out.println(a.add(111));
        System.out.println(a.add(222));
        System.out.println(a);

        System.out.println("\n********** checkIndex, get test **********");
        System.out.println(a.get(0));
        System.out.println(a.get(2));
        //System.out.println(a.get(3)); do return error

        System.out.println("\n********** add,size,set,node test **********");
        a.add(0,333);
        System.out.println("size = "+ a.size()+" "+a);
        a.add(3,444);
        System.out.println("size = "+ a.size()+" "+a);
        System.out.println("set return "+a.set(3,555));
        System.out.println(a);

        System.out.println("\n********** isEmpty,remove test **********");
        single.SinglyLinkedList<String> b = new single.SinglyLinkedList<>();
        System.out.println(b.isEmpty());
        System.out.println(a.isEmpty());
        System.out.println("remove return: "+a.remove(0));
        System.out.println(a);
        System.out.println("remove return: "+a.remove(3));
        System.out.println(a);

        System.out.println("\n********** String test **********");
        b.add("one");
        b.add("two");
        b.add("three");
        System.out.println(b);
        b.remove(2);
        System.out.println(b);



        //new test
        single.SinglyLinkedList<Integer> c = new single.SinglyLinkedList<>();
        System.out.println(c);
        c.add(0,111);
        System.out.println(c);
        c.add(0,111);
        System.out.println(c);
    }
}
