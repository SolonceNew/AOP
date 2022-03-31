package org.example.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    public String getBook() {
        return Book;
    }

    @Value("Преступление и наказание")
    private String Book;


}
