package com.compony;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    //test{Method}_Should{Do}_When{Condition}

    @Test
    void testAdd_ShouldAddedElement_WhenEmptyList() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

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
    void testAdd_ShouldAddedBeginElement() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        list.add("супер");
        list.add("Java");
        list.add("программист");
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
    void testAdd_ShouldAddedFirstHalfElement() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("программист");
        list.add("!");
        list.add(2, "Java");

        assertAll("",
                () -> assertEquals(5, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3)),
                () -> assertEquals("!", list.get(4))
        );
    }

    @Test
    void testAdd_ShouldAddedSecondHalfElement() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("!");
        list.add(3, "программист");

        assertAll("",
                () -> assertEquals(5, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3)),
                () -> assertEquals("!", list.get(4))
        );
    }

    @Test
    void indexOf() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        list.add("Я");
        list.add("супер");
        list.add("Java");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals(0, list.indexOf("Я")),
                () -> assertEquals(1, list.indexOf("супер")),
                () -> assertEquals(2, list.indexOf("Java")),
                () -> assertEquals(3, list.indexOf("программист"))
        );
    }

    @Test
    void removeByIndex() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

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

        list.add(2,"Java");

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    @Test
    void removeOneElementByIndex() {

    }

    @Test
    void removeFirstOfTwoElementsByIndex() {

    }

    @Test
    void removeSecondOfTwoElementsByIndex() {

    }

    @Test
    void removeFirstOfManyByIndex() {

    }

    @Test
    void removeLastOfManyByIndex() {

    }

    @Test
    void removeInMiddleOfManyByIndex() {

    }

    @Test
    void removeOneElementByElement() {

    }

    @Test
    void removeFirstElementOfTwoElementByElement() {

    }

    @Test
    void removeSecondElementOfTwoElementByElement() {

    }

    @Test
    void removeFirstOfManyByElement() {

    }

    @Test
    void removeLastOfManyByElement() {

    }

    @Test
    void removeInMiddleOfManyByElement() {

    }

    @Test
    void removeNotExistElementOfManyByElement() {

    }

    @Test
    void clear() {

    }



}