package io.h2o.repository;

import io.h2o.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {
    List<Book> findByStudentId(int id);
}
