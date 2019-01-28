package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    private ArrayList<Entry<String>> entries = new ArrayList<>();
    private int size = 0;
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("0");
        entries.add(root);
    }

    @Override
    public String get(int index) {
        //return null;
        throw new UnsupportedOperationException();
    }

    public String getParent(String element) {
        String parent = "";
        for (Entry<String> entry : entries) {
            if (entry.elementName.equals(element)) {
                parent = entry.parent.elementName;
            }
        }
        return parent;
    }

    @Override
    public String set(int index, String element) {
        //return super.set(index, element);
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        //super.add(index, element);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String element) {
        boolean result = false;
        for (Entry<String> entry : entries) {
            if (entry.isAvailableToAddChildren()) {
                entry.checkChildren();
                if (entry.availableToAddLeftChildren) {
                    Entry<String> newEntry = new Entry<>(element);
                    entry.leftChild = newEntry;
                    newEntry.parent = entry;
                    entries.add(newEntry);
                    result = true;
                    size++;
                    break;
                }
                if (entry.availableToAddRightChildren) {
                    Entry<String> newEntry = new Entry<>(element);
                    entry.rightChild = newEntry;
                    newEntry.parent = entry;
                    entries.add(newEntry);
                    result = true;
                    size++;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String remove(int index) {
        //return super.remove(index);
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        //return super.subList(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        //super.removeRange(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        //return super.addAll(index, c);
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.size;
    }

    //public void print() {
    //    for (Entry<String> entry : entries) {
    //        System.out.println(entry.elementName);
    //        if (entry.parent != null) {
    //            System.out.println("    Parent " + entry.parent.elementName);
    //        }
    //    }
    //}



    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddRightChildren = true;
            this.availableToAddLeftChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }
}