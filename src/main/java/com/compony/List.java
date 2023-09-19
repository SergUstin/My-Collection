package com.compony;


public interface List<T> {

    int size();

    void add(T element);

    void add(int index, T element);

    void remove(int index);

    boolean remove(T element);

    T get(int index);

    void set(int index, T element);

    int indexOf(T element);

    void clear();

    boolean contains(T element);
}
