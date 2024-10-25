package com.assignment.app;

import com.assignment.app.model.Course;
import com.assignment.app.model.Student;
import com.assignment.app.repository.CourseRepository;
import com.assignment.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student();
//		student.setName("Archee Arjun");
//		studentRepository.save(student);
//		System.out.println("saved");


		// Create courses
		Course course1 = new Course("Math 101");
		Course course2 = new Course("History 101");
		courseRepository.save(course1);
		courseRepository.save(course2);

		// Create students
		Student student1 = new Student("Alice");
		Student student2 = new Student("Bob");

		// Enroll students in courses
		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course1));

		studentRepository.save(student1);
		studentRepository.save(student2);

		// Associate the students with the courses (bidirectional relationship setup)
		course1.getStudents().add(student1);
		course1.getStudents().add(student2);
		course2.getStudents().add(student1);

		courseRepository.save(course1);
		courseRepository.save(course2);

	}
}
