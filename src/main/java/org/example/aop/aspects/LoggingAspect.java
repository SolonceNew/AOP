package org.example.aop.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    // работает для всех, которые подходят под шаблон в данном случае 2 класса
    // SchoolLibralry & UniLibrary
   // @Before("execution(public void getBook())")
    //public void beforeGetBookAdvice() {
      //  System.out.println("before getBookAdvice: была попытка получить книгу");
    //}


    //сработает только для класса Unilibrary
  //  @Before("execution(public void org.example.aop.UniLibrary.getBook())")
    //public void beforeGetBookAdvice() {
      //  System.out.println("before getBookAdvice: была попытка получить книгу");
    //}

    //сработает для всех методов, которые начинаются с get
    @Before("execution(public void get*())")
    public void beforeGetBookAdvice() {
        System.out.println("before getBookAdvice: была попытка получить книгу");
    }

   // @Before("execution(public void returnBook())")
    //public void beforeReturnBookAdvice() {
      //  System.out.println("before returnBookAdvice: была попытка вернуть книгу");
    //}

    //Подходит для любого returnType
    //Если мы уберем access modifier и оставим звездочку, то под этот pointcut подойдет метод с
    // с любым access modifier
    @Before("execution(public * returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("before returnBookAdvice: была попытка вернуть книгу");}

}
