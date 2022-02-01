package io.h2o.vo;

import io.h2o.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
    private Student student;
    private List<Book> bookList;
}
