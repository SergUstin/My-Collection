package com.compony.list;

import java.util.Objects;

public class DoubleLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {

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
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("не корректный индекс");
        }

        if (size == 1) {
            first = null;
            last = null;
        } else if (size == 2) {
            if (index == 0) {
                first = last;
                last.previous = null;
            } else {
                last = first;
                first.next = null;
            }
        } else if (index == 0) {
            first = first.next;
            first.previous = null;
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
        } else {
            Node<T> node = getNode(index);
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

    @Override
    public boolean remove(T element) {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            if (Objects.equals(first.element, element)) {
                first = null;
                last = null;
                size--;
                return true;
            }
            return false;
        }

        if (size == 2) {
            if (Objects.equals(first.element, element)) {
                first = last;
                last.previous = null;
                size--;
                return true;
            } else if (Objects.equals(last.element, element)) {
                last = first;
                first.next = null;
                size--;
                return true;
            }
            return false;
        }

        if (Objects.equals(first.element, element)) {
            first = first.next;
            first.previous = null;
            size--;
            return true;
        } else {
            Node<T> node = first;

            for (int i = 1; i < size; i++) {
                if (Objects.equals(node.next.element, element)) {
                    node.next = node.next.next;
                    if (i == size - 1) {
                        last = node;
                    } else {
                        node.next.previous = node;
                    }
                    size--;
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public void set(int index, T element) {
        Node<T> node = getNode(index);
        node.element = element;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.element, element)) {
                return i;
            }
            node = node.next;
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
