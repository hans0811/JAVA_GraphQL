package com.hans.graphql.service;

import com.hans.graphql.entity.Address;
import com.hans.graphql.entity.Student;
import com.hans.graphql.entity.Subject;
import com.hans.graphql.repo.AddressRepository;
import com.hans.graphql.repo.StudentRepository;
import com.hans.graphql.repo.SubjectRepository;
import com.hans.graphql.request.CreateStudentRequest;
import com.hans.graphql.request.CreateSubjectRequest;
import com.hans.graphql.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hans
 */
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    AddressRepository addressRepository;

    public Student getStudentById(long id) {
        System.out.println("Inside getStudentByID");
        return studentRepository.findById(id).get();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){

        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        student.setAddress(address);
        student = studentRepository.save(student);

        List<Subject> subjectsList = new ArrayList<>();

        if(createStudentRequest.getSubjectsLearning() != null){
            for(CreateSubjectRequest createSubjectRequest :
                    createStudentRequest.getSubjectsLearning()){
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjectsList.add(subject);
            }

            subjectRepository.saveAll(subjectsList);
        }

        student.setLearningSubjects(subjectsList);

        return student;

    }
}
