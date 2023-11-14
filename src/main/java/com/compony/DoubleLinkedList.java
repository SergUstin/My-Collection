package com.compony;

public class DoubleLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public static class Node<T> {

        private T element;
        private Node<T> next;
        private Node<T> previous;
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

        if (size == 0) {
            first = node;
            last = node;
        } else if (index == size) {
            last.next = node;
            node.previous = last;
            last = node;
        } else if (index == 0) {
            first.previous = node;
            node.next = first;
            first = node;
        } else {
            Node<T> corruntNode = getNode(index);
            node.next = corruntNode;
            node.previous = corruntNode.previous;
            corruntNode.previous.next = node;
            corruntNode.previous = node;
        }
        size++;
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
        return getNode(index).element;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }

        Node<T> node;

        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
        }
        return node;
    }
}
