package com.compony;

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
    void addWrongEmptyList () {
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
    void removedFirstOfTwoElement() { // Не работает тест, найти ошибку, дописать тесты
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.remove(0);

        assertEquals(1, list.size());

        list.add(0,"Я");
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


}