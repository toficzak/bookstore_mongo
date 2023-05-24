package com.github.toficzak.book_store.a;

import com.github.toficzak.book_store.repo.Book;
import com.github.toficzak.book_store.repo.RepoBook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class EndpointBook {

private final RepoBook repoBook;

@GetMapping("/{name}")
    ResponseBook get(@PathVariable("name") String name) {
    Book book = repoBook.findByName(name);
    return book.toResponse();

}


    @PostMapping
    ResponseBook create(@RequestBody RequestBook book) {
        Book bookEntity = new Book(book.name());
        repoBook.save(bookEntity);
        return repoBook.findByName(book.name()).toResponse();
    }
}
