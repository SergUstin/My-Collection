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
        // Заполнить стек 4 элементами
        // проверим что 4 элемента
        // удалить 2 элемента используя pop()
        // проверить, что осталось два элемента

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
        // Создать стэк
        // Удалить элемент через pop() и проверить, что вернулось null
        // Проверить размерность на 0

        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peek() {
        // Заполнить стек 4 элементами
        // проверим что 4 элемента
        // Возьмем элемент через peek() и проверим что размерность не изменилась
        // проверить что 4 элемента

        stack.push("Alpha");
        stack.push("Beta");
        stack.push("Gamma");
        stack.push("Delta");

        assertEquals(4, stack.size());

        stack.peek();

        assertEquals(4, stack.size());
    }

    // Написать тест, который проверит, что в случае если push() передается null выдается нужный exception
    @Test
    void testPush_ShouldThrowEx_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class,() -> stack.push(null));
    }

    // Написать тест, который при передачи в push() значение null, выдаст нужный текст нашего exception
    @Test
    void testPush_ShouldThrowExTextMessage_WhenArgsNull() {
        assertThrows(IllegalArgumentException.class, () -> stack.push(null), "Element can not be Null");
    }
}