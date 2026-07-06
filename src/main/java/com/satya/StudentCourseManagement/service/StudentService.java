package com.satya.StudentCourseManagement.service;

import com.satya.StudentCourseManagement.model.Student;
import com.satya.StudentCourseManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found with id: "+id));
    }

    public Student updateStudent(Long id, Student studentDetails) {

        Student oldStudent=studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found with id " + id));

            oldStudent.setName(studentDetails.getName());
            oldStudent.setEmail(studentDetails.getEmail());
            oldStudent.setMobileNumber(studentDetails.getMobileNumber());
            oldStudent.setCourses(studentDetails.getCourses());
            oldStudent.setAddress(studentDetails.getAddress());
            oldStudent.setGender(studentDetails.getGender());
            oldStudent.setDateOfBirth(studentDetails.getDateOfBirth());
            return studentRepository.save(oldStudent);

    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}
