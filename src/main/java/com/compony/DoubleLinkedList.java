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
        return 0;
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
        return null;
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
}
