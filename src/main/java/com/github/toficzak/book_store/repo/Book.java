package com.github.toficzak.book_store.repo;

import com.github.toficzak.book_store.a.ResponseBook;
import org.springframework.data.annotation.Id;

public class Book {

    @Id
    private String id;
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public ResponseBook toResponse() {
        return new ResponseBook(this.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
