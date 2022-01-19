package com.hans.graphql.response;

import com.hans.graphql.entity.Subject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hans
 */
@Getter
@Setter
public class SubjectResponse {

    private Long id;

    private String subjectName;

    private Double marksObtained;

    public SubjectResponse(Subject subject){
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.marksObtained = subject.getMarksObtained();
    }
}
