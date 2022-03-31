package org.example.aop.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

  //  @Before("execution(public void getBook(String))")
  //  public void beforeGetBookAdvice() {
  //      System.out.println("before getBookAdvice: была попытка получить книгу");
  //  }

    //подходит любой метод с любым одним параметром
    // @Before("execution(public void *(*))")
    //public void beforeGetBookAdvice() {
      //  System.out.println("before getBookAdvice: была попытка получить книгу");
    //}

    //подходит любой метод с любым количеством параметров
   // @Before("execution(public void *(..))")
   // public void beforeGetBookAdvice() {
   //     System.out.println("before getBookAdvice: была попытка получить книгу");
   // }

    //подходит метод с параметром, у которого тип данных Book
    @Before("execution(public void getBook(org.example.aop.Book))")
    public void beforeGetBookAdvice() {
        System.out.println("before getBookAdvice: была попытка получить книгу");
    }






}
