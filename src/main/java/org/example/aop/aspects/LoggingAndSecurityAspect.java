package org.example.aop.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAndSecurityAspect {

 //поинткат, который будет подходить для всех методов класса юнилайбрари, кроме
 //ретерн мэгазин

 @Pointcut("execution(* org.example.aop.UniLibrary.*(..))")
 private void allMethodsFromUniLibrary() {}

 @Pointcut("execution(public void org.example.aop.UniLibrary.returnMagazine())")
 private void returnMagazineFromUniLibrary() {}

 @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
 private void allMethodsFromUniLibraryExceptReturnMagazine() {}

 @Before("allMethodsFromUniLibraryExceptReturnMagazine()")
 public void beforeAllMethodsExceptReturnMagazineAdvice() {
  System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing log #4");
 }
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


    //@Pointcut("execution(* get*())")
    //private void allGetMethods(){}

    //@Before("allGetMethods()")
    //public void beforeGetLoggingAdvice() {
    //  System.out.println("before getBookAdvice: была попытка получить книгу/Журнал");
    //}

    //@Before("allGetMethods()")
    //public void beforeGetSecurityAdvice() {
    //  System.out.println("before getSecurityAdvice: " +
    //        "праверка прав на получение книг/журнала");
    //}
}




