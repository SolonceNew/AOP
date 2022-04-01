package org.example.aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.aop.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение +" +
                "списка студентов перед методом getStudents");
    }

    @AfterReturning(pointcut = "execution(* getStudents())"
    , returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        //получаем информацию о первом студенте и меняем ему имя.Эдвайс выполняется
        // до выдачи нам конечного результата
        // в консоль, т.е. мы получаем уже обновленный результат в консоль.
        //Изменяется возвращаемый результат метода.
        //Важно комментировать такой код
        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr." + nameSurname;
        firstStudent.setNameSurname(nameSurname);
        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firstStudent.setAvgGrade(avgGrade);
        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение +" +
                "списка студентов после работы метода getStudents");
    }


}
