package com.compony;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<String> list;

    private void standardPhraseFourElement() {
        assertAll("Проверяем расположение в листе элементов",
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("програмист", list.get(3))
        );
    }

    private void standardPhraseFiveElement() {
        assertAll("Проверяем расположение в листе элементов",
                this::standardPhraseFourElement,
                () -> assertEquals("!", list.get(4))
        );
    }

    private void fillListThreeElement () {
        list.add("супер");
        list.add("Java");
        list.add("програмист");
    }

    private void fillListFourElement() {
        list.add("Я");
        fillListThreeElement();
    }

    @Test
    @DisplayName("Тест работы indexOf")
    void indexOf() {
        list = new ArrayList<>(3);

        fillListThreeElement();
        list.add(0, "Я");
        list.add("!");

        assertAll("Сценарий проверки метода indexOf",
                this::standardPhraseFourElement,
                () -> assertEquals(4, list.indexOf("!")),
                () -> assertEquals(-1, list.indexOf("Hello"))
        );
    }

    @Test
    @DisplayName("Проверка добавления элемента в конец")
    void add() {
        list = new ArrayList<>();

        fillListFourElement();

        assertAll("Сценарий проверки метода indexOf",
                () -> assertEquals(4, list.size()),
                this::standardPhraseFourElement
        );
    }

    @Test
    @DisplayName("Проверка добавления элементов с расширением")
    void addWithCapacity() {
        list = new ArrayList<>(2);

        fillListFourElement();
        assertAll("Сценарий проверки метода с увеличением вместимости",
                () -> assertEquals(4, list.size()),
                this::standardPhraseFourElement
        );
    }

    @Test
    @DisplayName("Проверка добавления в начало")
    void addWithRecreateLeft() {
        list = new ArrayList<>(3);

        fillListThreeElement();

        list.add(0, "Я");
        list.add("!");

        assertAll("Сценарий проверки добавления елементов со сдвигом в ???",
                () -> assertEquals(5, list.size()),
                this::standardPhraseFiveElement
        );
    }
}