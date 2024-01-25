package com.compony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<String> stack;

    @BeforeEach
    void init() {
        stack = new Stack<>();
    }


    @Test
    void push() {
        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Gamma");
        stack.push("Delta");

        assertEquals(4, stack.size());

        stack.pop();
        stack.pop();

        assertEquals(2, stack.size());
    }

    @Test
    void pop() {
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peek() {
        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Gamma");
        stack.push("Delta");

        assertEquals(4, stack.size());

        stack.peek();

        assertEquals(4, stack.size());
    }

    @Test
    void testPush_ShouldThrowEx_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class,() -> stack.push(null));
    }

    @Test
    void testPush_ShouldThrowExTextMessage_WhenArgsNull() {
        try {
            stack.push(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Element can not be Null", e.getMessage());
        }
    }
}