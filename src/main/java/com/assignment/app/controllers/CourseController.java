package com.assignment.app.controllers;

import com.assignment.app.model.Course;
import com.assignment.app.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // List all courses
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "listCourses";
    }

    // Show form to add a new course
    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse";
    }

    // Add a new course
    @PostMapping("/add")
    public String addCourse(@RequestParam String name) {
        courseService.addCourse(name);
        return "redirect:/courses";
    }

    // Show form to edit an existing course
    @GetMapping("/edit/{id}")
    public String showEditCourseForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id).orElse(null);
        model.addAttribute("course", course);
        return "editCourse";
    }

    // Update an existing course
    @PostMapping("/update")
    public String updateCourse(@RequestParam Long id, @RequestParam String name) {
        courseService.updateCourse(id, name);
        return "redirect:/courses";
    }

    // Delete a course
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    // Show course details
    @GetMapping("/details/{id}")
    public String showCourseDetails(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id).orElse(null);
        model.addAttribute("course", course);
        return "courseDetails";
    }

}
