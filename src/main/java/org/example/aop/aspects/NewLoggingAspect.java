package org.example.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются " +
                "вернуть книгу");
        Object targetMethodResult = null;
        //внутри around можно обрабатывать исключения, но это не лучший вариант.
        //Можно пробрасывать исключения
        try {
            //вызываем таргет метод
         targetMethodResult =  proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // таргет не успел передать значение
            System.out.println("aroundReturnBookLoggingAdvice: " +
                    "было поймано исключение " + e);
            throw e;
        }
            targetMethodResult = "Неизвестное название книги";
   
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку " +
                "успешно вернули книгу");

        return targetMethodResult;
    }
}
