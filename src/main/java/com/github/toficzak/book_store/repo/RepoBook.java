package com.github.toficzak.book_store.repo;

import com.github.toficzak.book_store.a.RequestBook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  RepoBook extends MongoRepository<Book, Long> {

//    @Query("{name: '?0'}")
    Book findByName(String name);



}
