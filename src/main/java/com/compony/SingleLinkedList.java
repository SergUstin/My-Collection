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
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("не корректный индекс");
        }
        Node<T> node = new Node<>();
        node.element = element;

        if (index == size) {
            if (size == 0) {
                first = node;
            } else {
                last.next = node;
            }
            last = node;
            size++;
            return;
        }

        if (index == 0) {
            node.next = first;
            first = node;
            size++;
            return;
        }

        Node<T> previous = first;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }

        node.next = previous.next;
        previous.next = node;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }

        if (size == 1) {
            first = null;
            last = null;
            size--;
            return;
        }

        if (size == 2) {
            if (index == 0) {
                first = last;
            } else {
                last = first;
                first.next = null;
                size--;
                return;
            }
        }

        if (index == 0) {
            first = first.next;
            size--;
            return;
        }

        Node<T> previous = first;

        for (int i = 1; i < index ; i++) {
            previous = previous.next;
        }

        previous.next = previous.next.next;

        if (index == size - 1) {
            last = previous;
        }
        size--;
    }

    @Override
    public boolean remove(T element) {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            return removeWhenOne(element);
        }
        if (size == 2) {
            return removeWhenTwo(element);
        }
        return findAndRemove(element);
    }

    private boolean removeWhenOne(T elment) {
        if (Objects.equals(first.element, elment)) {
            first = null;
            last = null;
            size--;
            return true;
        } else {
            return false;
        }
    }

    private boolean removeWhenTwo(T elment) {
        return false;
    }

    private boolean findAndRemove(T elment) {
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
