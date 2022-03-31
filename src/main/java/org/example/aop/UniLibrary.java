package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из Unilibrary");
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу");
    }

    public void getMagazine() {

        System.out.println("Мы берем журнал из Unilibrary");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в unilibrary");
    }

    public void addBook() {
        System.out.println("Мы добавляем книгу в unilibrary");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в unilibrary");
    }
 }
