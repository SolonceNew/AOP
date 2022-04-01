package org.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        //SchoolLibrary schoolLibrary = context.getBean("schoolLibrary",
          //      SchoolLibrary.class);
        Book book = context.getBean("book", Book.class);
        library.addBook("Anna", book);
        library.addMagazine();
      // library.returnMagazine();
       //library.addBook();
        //library.returnBook();
        //schoolLibrary.getBook();
        context.close();
    }
}
