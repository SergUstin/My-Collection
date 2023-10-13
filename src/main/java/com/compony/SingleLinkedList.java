package com.compony;

import java.util.Objects;

public class SingleLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private T element;
        private Node<T> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {

    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        Node<T> firstNode = first;
        for (int i = 0; i < index; i++) {
            firstNode = firstNode.next;
        }
        return firstNode.element;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        Node<T> firstNode = first;
        for (int i = 0; i < index; i++) {
            firstNode = firstNode.next;
        }
        firstNode.element = element;
    }

    @Override
    public int indexOf(T element) {
        Node<T> firstNode = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(firstNode.element, element)) {
                return i;
            }
            firstNode = firstNode.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
}
