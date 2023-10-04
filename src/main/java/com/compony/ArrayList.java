package com.compony;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class ArrayList<T> implements List<T> {

    private Object[] items;
    private int size;
    private int start;

    public ArrayList() {
        items = new Object[10];
    }

    public ArrayList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("вместимость должна быть больше ноля");
        }
        items = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        if (size == 0) {
            items[start] = element;
        } else if (size < items.length) { // Есть резерв
            if (index <= size / 2) {  // Вставка в первую половину
                if (start == 0) { // Нет резерва в начале
                    addLeftShift(index, element);
                } else { // Есть резерв в начале
                    addLeft(index, element);
                }
            } else {  // Вставка во вторую половину
                if (start + size < items.length) { // Есть резерв в конце
                    addRight(index, element);
                } else { // Нет резерва в конце
                    addRightShift(index, element);
                }
            }
        } else { // Резерва нет
            recreateItems(index, element);
        }
        size++;
    }

    private void addLeftShift(int index, T element) {
        for (int i = size - 1; i >= index ; i--) {
            items[start + i + 1] = items[i];
        }
        items[start + index] = element;
        for (int i = index - 1; i >= 0 ; i--) {
            items[start + i] = items[i];
        }
        Arrays.fill(items, 0, start, null);
    }

    private void addLeft(int index, T element) {} // Попробуй реализовать
    private void addRight(int index, T element) {} // Попробуй реализовать
    private void addRightShift(int index, T element) {} // Попробуй реализовать

    private void recreateItems(int index, T elment) {
        int newStart = start;
        if (newStart == 0) {
            newStart = (items.length * 2 - size) / 2;
        }
        Object[] newItems = new Object[items.length / 2];
        for (int i = 0; i < index; i++) {
            newItems[newStart + i] = items[start + i];
        }
        newItems[newStart + index] = elment;
        for (int i = index; i < size; i++) {
            newItems[newStart + i] = items[start + i + 1];
        }
        items = newItems;
        start = newStart;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        if (items.length > size * 4) {
            recreateItems(index);
        } else {
            if (index <= size / 2) { // Удаление из левой части
                for (int i = index; i > 0; i--) {
                    items[start + i] = items[start + i - 1];
                }
                items[start] = null;
                start++;
            } else { // Удаление из правой части
                for (int i = index; i < size - 1; i++) {
                    items[start + i] = items[start + i + 1];
                }
                items[size] = null;
            }
        }
        size--;
    }

    private void recreateItems(int index) {
        int newStart = start;
        if (newStart == 0) {
            newStart = (items.length / 2 - size) / 2;
        }
        Object[] newItems = new Object[items.length / 2];
        for (int i = 0; i < index; i++) {
            newItems[newStart + i] = items[start + i];
        }
        for (int i = index; i < size - 1; i++) {
            newItems[newStart + i] = items[start + i + 1];
        }
        items = newItems;
        start = newStart;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        return (T) items[start + index];
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        items[start + index] = element;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[start + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
}
