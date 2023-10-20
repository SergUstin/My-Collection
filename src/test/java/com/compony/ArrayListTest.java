package com.compony;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList<String> list;

    private void standardPhraseFourElement() {
        assertAll("Проверяем расположение в листе элементов",
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("программист", list.get(3))
        );
    }

    private void standardPhraseFiveElement() {
        assertAll("Проверяем расположение в листе элементов",
                this::standardPhraseFourElement,
                () -> assertEquals("!", list.get(4))
        );
    }

    private void fillListThreeElement() {
        list.add("супер");
        list.add("Java");
        list.add("программист");
    }

    private void fillListFourElement() {
        list.add("Я");
        fillListThreeElement();
    }

    private void fillListFiveElement() {
        fillListFourElement();
        list.add("!");
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
    @DisplayName("Метод add добавление в начало, когда резерва нет")
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

    @Test
    @DisplayName("Метод add добавление в начало, когда есть резерв")
    void addWithLeftReserve() {
        list = new ArrayList<>(3);

        list.add("Java");
        list.add("программист");
        list.add("!");
        list.add(0, "Я");
        list.add(1, "супер");

        assertAll("",
                () -> assertEquals(5, list.size()),
                this::standardPhraseFiveElement
        );
    }

    @Test
    @DisplayName("Метод add добавление, с резервом в конце")
    void addWithLeftShift() {
        // Создать лист на 4 элемента
        // Добавить элемент в первый индекс - проверить что все находиться на своих местах
        list = new ArrayList<>(4);

        list.add("Я");
        list.add("Java");
        list.add("программист");
        list.add(1, "супер");

        assertAll("",
                () -> assertEquals(4, list.size()),
                this::standardPhraseFourElement
        );

    }

    @Test
    @DisplayName("Метод add добавление, со сдвигом")
    void addWithRightShift() {
        // Создать лист на 4 элемента
        // Добавляем два элемента, один в нулевой индекс и в конец - проверить что все находиться на своих местах
        list = new ArrayList<>(4);

        list.add("супер");
        list.add("Java");
        list.add(0, "Я");
        list.add("программист");

        assertAll("",
                () -> assertEquals(4, list.size()),
                this::standardPhraseFourElement
        );
    }

    @Test
    @DisplayName("Удаление элемента с лева от середины")
    void removeLeft() {
        // Создать лист на 5 элемента
        // Удаляем элемент по индексу 1 - проверить что все находиться на своих местах

        list = new ArrayList<>();

        fillListFiveElement();
        list.remove(1);

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("Java", list.get(1)),
                () -> assertEquals("программист", list.get(2)),
                () -> assertEquals("!", list.get(3))
        );
    }

    @Test
    @DisplayName("Удаление элемента с права от середины")
    void removeRight() {
        // Создать лист на 5 элементов
        // Удаляем элемент по индексу 3 - проверить что все находиться на своих местах

        list = new ArrayList<>();

        fillListFiveElement();
        list.remove(3);

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("супер", list.get(1)),
                () -> assertEquals("Java", list.get(2)),
                () -> assertEquals("!", list.get(3))
        );
    }

    @Test
    @SneakyThrows
    @DisplayName("Уменьшение размерности внутреннего массива")
    void reduceSize() {
        list = new ArrayList<>(100);

        fillListFiveElement();
        list.remove(1);

        assertAll("",
                () -> assertEquals(4, list.size()),
                () -> assertEquals("Я", list.get(0)),
                () -> assertEquals("Java", list.get(1)),
                () -> assertEquals("программист", list.get(2)),
                () -> assertEquals("!", list.get(3))
        );

        Field field = ArrayList.class.getDeclaredField("items");
        field.setAccessible(true);
        assertEquals(50, ((Object[]) field.get(list)).length);
    }


}