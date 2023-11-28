package com.compony.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleQueueTest {
    private SimpleQueue<String> queue;

    @BeforeEach
    void init() {
        queue = new SimpleQueue<>();
    }

    @Test
    @DisplayName("тест на уменьшение очереди при удалении элемента")
    void pull() {
        queue.put("Alpha");
        queue.put("Beta");
        queue.put("Gamma");
        queue.put("Delta");

        assertEquals(4, queue.size());

        assertEquals("Alpha", queue.pull());
        assertEquals(3, queue.size());
    }

    @Test
    void get() {
        assertNull(queue.pull());
        assertEquals(0, queue.size());
    }

    @Test
    void peek() {
        queue.put("Alpha");
        queue.put("Beta");
        queue.put("Gamma");
        queue.put("Delta");

        assertEquals(4, queue.size());

        assertEquals("Alpha", queue.peek());
        assertEquals(4, queue.size());

    }

    @Test
    void getPeek() {
        assertNull(queue.peek());
        assertEquals(0, queue.size());
    }

    @Test
    void testPut_ShouldThrowIllegalArgumentEx_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class, () -> queue.put(null));
    }

    @Test
    void testPut_ShouldThrowExTextMessage_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class, () -> queue.put(null), "Args not been null");
    }

    @Test
    void putMessage() {
        try {
            queue.put(null);
            fail("Ex can not be throw");
        } catch (IllegalArgumentException e) {
            assertEquals("Args not been null", e.getMessage());
        }
    }
}