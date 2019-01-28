package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
        }
        else {
            SearchVisitor searchVisitor = new SearchVisitor();
            Files.walkFileTree(path, searchVisitor);
            System.out.println("Всего папок - " + searchVisitor.getCountD());
            System.out.println("Всего файлов - " + searchVisitor.getCountF());
            System.out.println("Общий размер - " + searchVisitor.getSize());
        }
    }

    public static class SearchVisitor extends SimpleFileVisitor<Path> {
        private int countD = -1;
        private int countF = 0;
        private long size = 0;
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            this.countD++;
            return super.preVisitDirectory(dir, attrs);
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            this.countF++;
            this.size += attrs.size();
            return super.visitFile(file, attrs);
        }
        public int getCountD() {
            return countD;
        }
        public int getCountF() {
            return countF;
        }
        public long getSize() {
            return size;
        }
    }
}