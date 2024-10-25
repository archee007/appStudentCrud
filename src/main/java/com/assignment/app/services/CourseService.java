package com.assignment.app.services;

import com.assignment.app.model.Course;
import com.assignment.app.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create a new course
    public Course addCourse(String name) {
        Course course = new Course(name);
        return courseRepository.save(course);
    }

    // Get a course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // List all courses
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    // Update an existing course
    public Course updateCourse(Long id, String name) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setName(name);
            return courseRepository.save(course);
        }
        return null;
    }

    // Delete a course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
