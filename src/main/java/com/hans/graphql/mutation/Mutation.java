package com.hans.graphql.mutation;

import com.hans.graphql.request.CreateStudentRequest;
import com.hans.graphql.response.StudentResponse;
import com.hans.graphql.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author hans
 */
@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        return new StudentResponse(studentService.createStudent(createStudentRequest));

    }
}
