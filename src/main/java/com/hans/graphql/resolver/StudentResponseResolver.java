package com.hans.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hans.graphql.entity.Subject;
import com.hans.graphql.enums.SubjectNameFilter;
import com.hans.graphql.response.StudentResponse;
import com.hans.graphql.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */
@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse,
                            SubjectNameFilter  subjectNameFilter){

        List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                if (subjectNameFilter.name().equalsIgnoreCase("ALL")) {
                    learningSubjects.add(new SubjectResponse(subject));
                } else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }

        return learningSubjects;
    }

    public String getFullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }

}
