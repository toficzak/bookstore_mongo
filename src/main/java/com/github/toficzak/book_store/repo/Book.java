package com.github.toficzak.book_store.repo;

import com.github.toficzak.book_store.a.ResponseBook;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document("books") <-- explicite, absent means same collection name as class name
public class Book {

    @Id
    private String id;
    private String name;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ResponseBook toResponse() {
        return new ResponseBook(this.name);
    }
}
