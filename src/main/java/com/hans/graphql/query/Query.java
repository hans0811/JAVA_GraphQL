package com.hans.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hans.graphql.request.SampleRequest;
import com.hans.graphql.response.StudentResponse;
import com.hans.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hans
 */
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String secondQuery() {
        return "Second Query";
    }

//    public String fullName(String firstName, String lastName){
//        return firstName + " " + lastName;
//    }

    public String fullName(SampleRequest sampleRequest){
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    public StudentResponse getStudent(long id){
        return new StudentResponse(studentService.getStudentById(id));
    }

}
