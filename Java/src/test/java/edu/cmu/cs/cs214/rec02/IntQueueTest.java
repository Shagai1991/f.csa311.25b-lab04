package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * This test class is for testing the implementations of the IntQueue interface.
 */
public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    @Before
    public void setUp() {
        mQueue = new ArrayIntQueue(); // Testing ArrayIntQueue implementation
        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(mQueue.isEmpty()); // Check if the queue is empty initially
    }

    @Test
    public void testNotEmpty() {
        mQueue.enqueue(1); // Enqueue an element
        assertFalse(mQueue.isEmpty()); // Queue should not be empty after enqueue
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(mQueue.peek()); // Peek should return null if the queue is empty
    }

    @Test
    public void testPeekNoEmptyQueue() {
        mQueue.enqueue(1);
        assertEquals(Integer.valueOf(1), mQueue.peek()); // Peek should return the head element
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(Integer.valueOf(testList.get(0)), mQueue.peek());
            assertEquals(i + 1, mQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        for (Integer value : testList) {
            mQueue.enqueue(value);
        }
        for (Integer value : testList) {
            assertEquals(value, mQueue.dequeue()); // Dequeue should return elements in order
        }
    }
    @Test
public void testDequeueOrder() {
    for (int i = 0; i < 100; i++) {
        mQueue.enqueue(i);
    }
    for (int i = 0; i < 100; i++) {
        assertEquals(Integer.valueOf(i), mQueue.dequeue()); // Хүссэн утга буцаагдах ёстой
    }
}
@Test
public void testDequeueEmptyQueue() {
    assertNull(mQueue.dequeue());  // Queue хоосон бол null буцах ёстой
}



    @Test
    public void testContent() {
        for (Integer value : testList) {
            mQueue.enqueue(value);
        }
        for (Integer value : testList) {
            assertEquals(value, mQueue.dequeue());
        }
    }
    @Test
    public void testEnsureCapacity() {
        for (int i = 0; i < 100; i++) {
            mQueue.enqueue(i); // 100 элемент нэмэх
        }
        assertEquals(100, mQueue.size()); // Хэмжээ 100 байх ёстой
    }

    @Test
    public void testClear() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        mQueue.clear();  // Бүх элементийг цэвэрлэнэ
        assertTrue(mQueue.isEmpty());  // queue хоосон байх ёстой
        assertEquals(0, mQueue.size());  // Хэмжээ 0 байх ёстой
        }

    

}
