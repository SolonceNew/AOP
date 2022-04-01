package org.example.aop.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aop.Book;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)
public class LoggingAspect {

    //поинткат, который будет подходить для всех методов класса юнилайбрари, кроме
    //ретерн мэгазин

// @Pointcut("execution(* org.example.aop.UniLibrary.*(..))")
//private void returnMagazineFromUniLibrary() {}

// @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
// private void allMethodsFromUniLibraryExceptReturnMagazine() {}

    //@Before("allMethodsFromUniLibraryExceptReturnMagazine()")
    //public void beforeAllMethodsExceptReturnMagazineAdvice() {
    // System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing log #4");
    //}
    //   @Pointcut("execution(* org.example.aop.UniLibrary.get*())")
    //   private void allGetMethodsFromUniLibrary() {}

    //   @Pointcut("execution(* org.example.aop.UniLibrary.return*())")
    //   private void allReturnMethodsFromUniLibrary() {}

    //сквозная логика для обоих методов - комбинирование поинткатов
    //   @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    //   private void allGetAndReturnMethodsFromUniLibrary() {}

    //   @Before("allGetMethodsFromUniLibrary()")
    //   public void beforeGettLoggingAdvice() {
    //       System.out.println("beforeGetLoggingAdvice: writing log #1");
    //   }

    //   @Before("allReturnMethodsFromUniLibrary()")
    //   public void beforeReturnLoggingAdvice() {
    //       System.out.println("beforeReturnLoggingAdvice: writing log #2");
    //   }

    //   @Before("allGetAndReturnMethodsFromUniLibrary()")
    //   public void beforeGetAndReturnLoggingAdvice() {
    //       System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");

    //   }


    @Before("org.example.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //получаем сигнатуру метода
        System.out.println("methodSignature = " + methodSignature);
        // из сигнатуры метода получаем сам метод
        System.out.println("methodSignature.getMethod = " + methodSignature.getMethod());
        //получаем тип возвращаемого значения метода
        System.out.println("MethodSignature.getReturnType = " + methodSignature.getReturnType());
        System.out.println("MethodSignature.getName = " + methodSignature.getName());
        if(methodSignature.getName().equals("addBook")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj : arg) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() + ", год издания - " +
                            myBook.getYearOfPublication());
                } else if(obj instanceof String) {
                    System.out.println("книгу в бибиотеку добавляет " + obj);
                }
            }
        }
        System.out.println("before getBookAdvice: логирование " +
                "попытки получить книгу/Журнал");
        System.out.println("--------------------------------");
    }
}





