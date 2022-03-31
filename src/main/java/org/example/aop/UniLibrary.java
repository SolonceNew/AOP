package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Мы взяли книгу из Unilibrary");
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из Unilibrary");
    }
 }
