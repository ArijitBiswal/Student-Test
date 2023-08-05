package com.student.service;

import com.student.dto.UpdateMarksRequest;
import com.student.entities.Student;
import com.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        student.setTotal(student.calculateTotal());
        student.setAverage(student.calculateAverage());
        student.setResult(student.calculateResult());

        return studentRepository.save(student);
    }

    public Student updateStudentMarks(Long studentId, UpdateMarksRequest updateMarksRequest) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setMark1(updateMarksRequest.getMarks1());
        student.setMark2(updateMarksRequest.getMarks2());
        student.setMark3(updateMarksRequest.getMarks3());
        student.setTotal(student.calculateTotal());
        student.setAverage(student.calculateAverage());
        student.setResult(student.calculateResult());

        return studentRepository.save(student);
    }


}
