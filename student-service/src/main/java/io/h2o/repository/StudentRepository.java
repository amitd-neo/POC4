package io.h2o.repository;

import io.h2o.domain.Student;
import io.h2o.vo.ResponseVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

}
