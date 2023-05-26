package com.github.toficzak.book_store.a;

import com.github.toficzak.book_store.repo.Book;
import com.github.toficzak.book_store.repo.RepoBook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class EndpointBook {

    private final RepoBook repoBook;
    private final MessageSender messageSender;

    @GetMapping
    List<ResponseBook> get() {
        messageSender.send();
        return repoBook.findAll().stream()
                .map(Book::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    ResponseBook get(@PathVariable("id") String id) {
        Book book = repoBook.findById(id).orElseThrow();
        return book.toResponse();
    }

    @GetMapping("/name/{name}")
    ResponseBook getByName(@PathVariable("name") String name) {
        Book book = repoBook.findByName(name).orElseThrow();
        return book.toResponse();
    }

    @PostMapping
    void create(@RequestBody RequestBook requestBook) {
        Book book = new Book(requestBook.name());
        repoBook.save(book);
        log.info("Saved: {}", book);
    }
}
