package io.h2o.service;

import io.h2o.domain.Student;
import io.h2o.repository.StudentRepository;
import io.h2o.vo.Book;

import io.h2o.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    public ResponseVO getStudentWithBook(int id) {
        ResponseVO vo = new ResponseVO();
        vo.setStudent(studentRepository.findById(id).get());
        Book[] forObject = restTemplate.getForObject("http://BOOK-SERVICE/api/book/byStudentId/" + id, Book[].class);
        List<Book> bookList = Arrays.stream(forObject)
                .map(object -> new Book(object.getId(),object.getBookName(),object.getAuthorName(),object.getStudentId()))
                .collect(Collectors.toList());
//        System.err.println(bookList);
        vo.setBookList(bookList);
        return vo;
    }
}
