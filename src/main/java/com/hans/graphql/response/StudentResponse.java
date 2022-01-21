package com.hans.graphql.response;

import com.hans.graphql.entity.Student;
import com.hans.graphql.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */

@Getter
@Setter


public class StudentResponse {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<SubjectResponse> learningSubjects;

    // This is for internal use. DO NOT PUT IN SCHEMA
    private Student student;

    private String fullName;

    public StudentResponse (Student student) {
        this.student = student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();

        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        /*if (student.getLearningSubjects() != null) {
            learningSubjects = new ArrayList<SubjectResponse>();
            for (Subject subject: student.getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }*/
    }
}
