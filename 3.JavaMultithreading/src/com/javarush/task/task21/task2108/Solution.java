package com.javarush.task.task21.task2108;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            String nameClone = this.getName();
            String[] branchesClone = new String[this.branches.length];
            System.arraycopy(branches, 0, branchesClone, 0, branches.length);
            return new Tree(nameClone, branchesClone);
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
