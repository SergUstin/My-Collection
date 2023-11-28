package com.compony.list;

import com.compony.list.SingleLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void add() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void addWithIndex() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("супер");
        list.add("Java");
        list.add("программист");
        list.add(0, "Я");
        list.add(1, ",");

        assertAll("",
                () -> assertEquals(5, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals(",", list.get(1)),
                () -> assertEquals("супер", list.get(2)),
                () -> assertEquals("Java", list.get(3)),
                () -> assertEquals("программист", list.get(4))
        );
    }

    @Test
    void addWrongEmptyList() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        assertThrows(IllegalArgumentException.class, () -> list.add(2, "!"));
    }

    @Test
    void set() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");
        list.set(3, "QA");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("QA", list.get(3))
        );
    }

    @Test
    void setWrong() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        assertThrows(IllegalArgumentException.class, () -> list.set(2, "!"));
    }

    @Test
    void indexOf() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertEquals(3, list.indexOf("программист"));
        assertEquals(-1, list.indexOf("QA"));
    }

    @Test
    void removeOneElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.remove(0);

        assertEquals(0, list.size());

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removedFirstOfTwoElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.remove(0);

        assertEquals(1, list.size());
        assertEquals("супер", list.get(0));

        list.add(0, "Я");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeSecondOfTwoElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.remove(1);

        assertEquals(1, list.size());
        assertEquals("Я", list.get(0));

        list.add(1, "супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeFirstElementOfMany() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        list.remove(0);

        assertAll("",
                () -> assertEquals(3, list.size()),
                () -> assertEquals("супер", list.get(0)),
                () -> assertEquals("Java", list.get(1)),
                () -> assertEquals("программист", list.get(2))
        );

        list.add(0, "Я");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeLastOfMany() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        list.remove(3);

        assertAll("",
                () -> assertEquals(3, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2))
        );

        list.add(3, "программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );

    }

    @Test
    void removeOfMany() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        list.remove(2);

        assertAll("",
                () -> assertEquals(3, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("программист", list.get(2))
        );

        list.add(2, "Java");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );

    }

    @Test
    void removeElementOfElements() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");

        assertTrue(list.remove("Я"));

        assertEquals(0, list.size());

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );

    }

    @Test
    void removeFirstOfTwoElementOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");

        assertTrue(list.remove("Я"));
        assertEquals(1, list.size());
        assertEquals("супер", list.get(0));

        list.add(0, "Я");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeSecondOfTwoElementOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");

        assertTrue(list.remove("супер"));
        assertEquals(1, list.size());
        assertEquals("Я", list.get(0));

        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeFirstOfManyOfElements() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertTrue(list.remove("Я"));

        assertAll("",
                () -> assertEquals(3, list.size()),
                () -> assertEquals("супер", list.get(0)),
                () -> assertEquals("Java", list.get(1)),
                () -> assertEquals("программист", list.get(2))
        );

        list.add(0, "Я");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeLastOfManyOfElements() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertTrue(list.remove("программист"));

        assertAll("",
                () -> assertEquals(3, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2))
        );

        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );

    }

    @Test
    void removeOfManyOfElements() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertTrue(list.remove("супер"));

        assertAll("",
                () -> assertEquals(3, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("Java", list.get(1)),
                () -> assertEquals("программист", list.get(2))
        );

        list.add(1, "супер");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeOfEmptyOfElements() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        assertFalse(list.remove("Hello"));
        assertEquals(0, list.size());

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );

    }

    @Test
    void clear() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        list.clear();
        assertEquals(0, list.size());

    }

}