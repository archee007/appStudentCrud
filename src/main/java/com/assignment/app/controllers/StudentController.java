package com.assignment.app.controllers;


import com.assignment.app.model.Course;
import com.assignment.app.model.Student;
import com.assignment.app.services.CourseService;
import com.assignment.app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // Dashboard - Home Page
    @GetMapping("/")
    public String showDashboard() {
        return "index";
    }

    // List all students
    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "listStudents";
    }

    // Show form to add a new student
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    // Add a new student
    @PostMapping("/add")
    public String addStudent(@RequestParam String name) {
        studentService.addStudent(name);
        return "redirect:/students";
    }

    // Show form to edit an existing student
    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id).orElse(null);
        model.addAttribute("student", student);
        return "editStudent";
    }

    // Update an existing student
    @PostMapping("/update")
    public String updateStudent(@RequestParam Long id, @RequestParam String name) {
        studentService.updateStudent(id, name);
        return "redirect:/students";
    }

    // Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


    // Show form to register a student in a course
    @GetMapping("/register/{studentId}")
    public String showRegisterInCourseForm(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId).orElse(null);
        List<Course> courses = courseService.findAll();
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);
        return "registerStudentInCourse";
    }

    // Register a student in a course
    @PostMapping("/registerStudentInCourse")
    public String registerStudentInCourse(@RequestParam Long studentId, @RequestParam Long courseId, Model model) {
        String result = studentService.registerStudentInCourse(studentId, courseId);
        model.addAttribute("message", result);
        return "redirect:/students";
    }

    // Show student details
    @GetMapping("/details/{id}")
    public String showStudentDetails(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id).orElse(null);
        model.addAttribute("student", student);
        return "studentDetails";
    }

}
