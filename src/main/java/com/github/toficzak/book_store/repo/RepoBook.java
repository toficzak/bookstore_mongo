package com.github.toficzak.book_store.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoBook extends MongoRepository<Book, String> {

    Optional<Book> findByName(String name);
}
