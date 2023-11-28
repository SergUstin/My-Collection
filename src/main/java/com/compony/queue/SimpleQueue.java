package com.compony.queue;

import java.util.Objects;

public class SimpleQueue<T> implements Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private T element;
        private Node<T> next;
    }

    public int size() {
        return size;
    }

    @Override
    public void put(T element) {
        if (Objects.isNull(element)) {
            throw new IllegalArgumentException("Args not been null");
        }

        Node<T> node = new Node<>();
        node.element = element;
        if (size == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return first.element;
    }

    @Override
    public T pull() {
        if (size == 0) {
            return null;
        }
        T element = first.element;
        first = first.next;
        size--;
        return element;
    }

    @Override
    public T firstElement() {
        if (size == 0) {
            return null;
        }
        return first.element;
    }

    @Override
    public T lastElement() {
        if (size == 0) {
            return null;
        }
        return last.element;
    }
}
