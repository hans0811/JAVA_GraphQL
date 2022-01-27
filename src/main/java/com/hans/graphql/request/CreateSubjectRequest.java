package com.hans.graphql.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hans
 */
@Getter
@Setter
public class CreateSubjectRequest {

    private String subjectName;

    private Double marksObtained;
}
