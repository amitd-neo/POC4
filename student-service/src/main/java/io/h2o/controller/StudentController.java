package io.h2o.controller;

import io.h2o.domain.Student;
import io.h2o.service.StudentService;
import io.h2o.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveBook(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.findById(id);
    }

    @GetMapping("/getStudentWithBook/{id}")
    public ResponseVO getStudentWithBook(@PathVariable int id){
        return studentService.getStudentWithBook(id);
    }
}
