package com.hans.graphql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * @author hans
 */

//@Getter
//@Setter
@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="subject_name")
    private String subjectName;

    @Column(name="marks_obtained")
    private Double marksObtained;

    //@ManyToOne(cascade = CascadeType.REFRESH)
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Subject() {
    }

    public Subject( String subjectName, Double marksObtained, Student student) {
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
