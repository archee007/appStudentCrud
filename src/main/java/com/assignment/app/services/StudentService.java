package com.assignment.app.services;

import com.assignment.app.model.Course;
import com.assignment.app.model.Student;
import com.assignment.app.repository.CourseRepository;
import com.assignment.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Create a new student
    public Student addStudent(String name) {
        Student student = new Student(name);
        return studentRepository.save(student);
    }

    // Get a student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // List all students
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Update an existing student
    public Student updateStudent(Long id, String name) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(name);
            return studentRepository.save(student);
        }
        return null;
    }

    // Delete a student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Register a student for a course
    public String registerStudentInCourse(Long studentId, Long courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            Student student = studentOptional.get();
            Course course = courseOptional.get();

            student.getCourses().add(course);
            course.getStudents().add(student);

            studentRepository.save(student);
            courseRepository.save(course);
            return "Student registered in course successfully!";
        }
        return "Student or course not found!";
    }
}
