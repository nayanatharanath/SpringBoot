package com.elibrary.bookservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elibrary.bookservice.model.Book;

@Repository
public interface BookRepo extends MongoRepository<Book, Long> {

}
