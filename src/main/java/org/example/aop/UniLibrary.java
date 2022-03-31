package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(Book book) {
        System.out.println("Мы берем книгу из Unilibrary " + book.getBook());
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу");
    }

    public void getMagazine() {

        System.out.println("Мы берем журнал из Unilibrary");
    }
 }
