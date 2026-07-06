package com.satya.StudentCourseManagement.service;

import com.satya.StudentCourseManagement.dto.DashboardStatsResponse;
import com.satya.StudentCourseManagement.repository.CourseRepository;
import com.satya.StudentCourseManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public DashboardService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public DashboardStatsResponse getDashboardStats() {
        long totalStudents = studentRepository.count();
        long totalCourses = courseRepository.count();
        long totalMaleStudents = studentRepository.countByGender("Male");
        long totalFemaleStudents = studentRepository.countByGender("Female");

        return new DashboardStatsResponse(totalStudents, totalCourses, totalMaleStudents, totalFemaleStudents);
    }
}
