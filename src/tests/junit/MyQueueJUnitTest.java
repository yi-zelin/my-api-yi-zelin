package tests.junit;

import org.junit.jupiter.api.Test;
import utils.MyQueue;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueJUnitTest{

    @Test
    void testMyQueue() {
        System.out.println();
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("---------------- Test Default Constructor( ) ----------------");
        System.out.println("size before: " + queue.size());
        System.out.println("queue Object Created ");

        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        System.out.println(queue);
        System.out.println("size after: " + queue.size());
        System.out.println();

    }


    @Test
    void testAdd() {
        System.out.println();
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("---------------- Test add(item) ----------------");
        assertTrue(queue.add("Red"));
        assertTrue(queue.add("Orange"));
        assertTrue(queue.add("Yellow"));
        assertTrue(queue.add("Green"));
        assertTrue(queue.add("Blue"));
        assertTrue(queue.add("Indigo"));
        assertTrue(queue.add("Violet"));

        System.out.println(queue);
        System.out.println("size: " + queue.size());
        assertEquals(7, queue.size());
        System.out.println();
    }


    @Test
    void testIsEmpty() {
        System.out.println();

        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("-------------- Test isEmpty() --------------");
        System.out.println(queue);
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());

        assertTrue(queue.add("Red"));
        assertTrue(queue.add("Orange"));
        assertTrue(queue.add("Yellow"));
        assertTrue(queue.add("Green"));
        assertTrue(queue.add("Blue"));
        assertTrue(queue.add("Indigo"));
        assertTrue(queue.add("Violet"));

        assertEquals(7, queue.size());
        assertFalse(queue.isEmpty());
        System.out.println(queue);
    }


    @Test
    void testPeekE() {
        System.out.println();
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("---------------- Test remove() ----------------");
        assertTrue(queue.add("Red"));
        assertTrue(queue.add("Orange"));
        assertTrue(queue.add("Yellow"));
        assertTrue(queue.add("Green"));
        assertTrue(queue.add("Blue"));
        assertTrue(queue.add("Indigo"));
        assertTrue(queue.add("Violet"));

        System.out.println(queue);
        System.out.println("size before: " + queue.size());
        assertEquals("Red"      , queue.peek());
        assertEquals("Red"      , queue.remove());
        assertEquals("Orange"   , queue.peek());
        assertEquals("Orange"   , queue.remove());
        assertEquals("Yellow"   , queue.peek());
        assertEquals("Yellow"   , queue.remove());
        System.out.println(queue);
        System.out.println("size after: " + queue.size());

        assertEquals("Green"    , queue.remove());
        assertEquals("Blue"     , queue.remove());
        assertEquals("Indigo"   , queue.remove());
        assertEquals("Violet"   , queue.remove());

        //Test for an Empty Queue
        assertNull(queue.peek());
        System.out.println();
    }



    @Test
    void testRemoveE() {
        System.out.println();
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("---------------- Test remove() ----------------");
        assertTrue(queue.add("Red"));
        assertTrue(queue.add("Orange"));
        assertTrue(queue.add("Yellow"));
        assertTrue(queue.add("Green"));
        assertTrue(queue.add("Blue"));
        assertTrue(queue.add("Indigo"));
        assertTrue(queue.add("Violet"));

        System.out.println(queue);
        System.out.println("size before: " + queue.size());
        assertEquals("Red"    , queue.remove());
        assertEquals("Orange" , queue.remove());
        assertEquals("Yellow" , queue.remove());
        assertEquals("Green"  , queue.remove());
        assertEquals("Blue"   , queue.remove());
        assertEquals("Indigo" , queue.remove());
        assertEquals("Violet" , queue.remove());
        System.out.println(queue);
        System.out.println("size after: " + queue.size());

        //Throws Exception if Empty.
        assertThrows(NoSuchElementException.class, queue::remove);
        System.out.println();
    }


    @Test
    void testSize() {

        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("---------------- Test size() ----------------");
        assertTrue(queue.add("Red"));
        assertTrue(queue.add("Orange"));
        assertTrue(queue.add("Yellow"));
        assertTrue(queue.add("Green"));
        assertTrue(queue.add("Blue"));
        assertTrue(queue.add("Indigo"));
        assertTrue(queue.add("Violet"));

        System.out.println(queue);
        assertEquals(7, queue.size());
        System.out.println("size end: " + queue.size());

        System.out.println();
    }


    @Test
    void testToString() {
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("---------------- Test toString Display() ----------------");
        assertTrue(queue.isEmpty());
        assertTrue(queue.add("Red"));
        assertTrue(queue.add("Orange"));
        assertTrue(queue.add("Yellow"));
        assertTrue(queue.add("Green"));
        assertTrue(queue.add("Blue"));
        assertTrue(queue.add("Indigo"));
        assertTrue(queue.add("Violet"));

        System.out.println();
        System.out.println();
        System.out.println("==== T  E  S  T      F  I  F  O ===");
        System.out.println();

        String value = "[Red, Orange, Yellow, Green, Blue, Indigo, Violet]";
        assertEquals(value , queue.toString());

        System.out.println(queue);
        assertEquals("Red", queue.remove());
        assertEquals("[Orange, Yellow, Green, Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Orange", queue.remove());
        assertEquals("[Yellow, Green, Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Yellow"  , queue.remove());
        assertEquals("[Green, Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Green" , queue.remove());
        assertEquals("[Blue, Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Blue", queue.remove());
        assertEquals("[Indigo, Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Indigo"   , queue.remove());
        assertEquals("[Violet]" , queue.toString());

        System.out.println(queue);
        assertEquals("Violet" , queue.remove());
        assertEquals("[]"     , queue.toString());

        System.out.println();
    }

}
