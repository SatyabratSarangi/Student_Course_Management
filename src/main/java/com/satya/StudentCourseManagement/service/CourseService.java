package com.satya.StudentCourseManagement.service;

import com.satya.StudentCourseManagement.model.Course;
import com.satya.StudentCourseManagement.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Course not found with id " + id));
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course oldCourse=courseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Course not found with id " + id));

        oldCourse.setCourseName(courseDetails.getCourseName());
        oldCourse.setCourseDescription(courseDetails.getCourseDescription());
        return courseRepository.save(oldCourse);

    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
