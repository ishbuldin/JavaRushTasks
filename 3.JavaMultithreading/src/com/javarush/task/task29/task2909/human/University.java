package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)
                result = student;
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = null;
        if (students.size() > 0) {
            double maxGrade = students.get(0).getAverageGrade();
            result = students.get(0);
            for (Student student : students) {
                if (student.getAverageGrade() > maxGrade) {
                    maxGrade = student.getAverageGrade();
                    result = student;
                }
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student result = null;
        if (students.size() > 0) {
            double minGrade = students.get(0).getAverageGrade();
            result = students.get(0);
            for (Student student : students) {
                if (student.getAverageGrade() < minGrade) {
                    minGrade = student.getAverageGrade();
                    result = student;
                }
            }
        }
        return result;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}