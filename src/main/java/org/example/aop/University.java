package org.example.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Anna Fabrichnaya", 3, 5.0);
        Student st2 = new Student("Petr Ivanov", 2, 3.3);
        Student st3 = new Student("Olga Petrova", 4, 4.6);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы getStudents");
        System.out.println(students.get(3));
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return students;

    }


}
