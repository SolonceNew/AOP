package org.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Book book = context.getBean("book", Book.class);
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary",
                SchoolLibrary.class);
        library.getBook(book);
       // library.getMagazine();
        //library.returnBook();
        //schoolLibrary.getBook();
        context.close();
    }
}
