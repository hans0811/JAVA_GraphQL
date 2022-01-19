package com.hans.graphql.service;

import com.hans.graphql.entity.Student;
import com.hans.graphql.repo.StudentRepository;
import com.hans.graphql.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hans
 */
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }
}
