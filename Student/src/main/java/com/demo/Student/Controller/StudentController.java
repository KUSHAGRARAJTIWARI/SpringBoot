package com.demo.Student.Controller;

import com.demo.Student.Exception.ResourceNotFoundException;
import com.demo.Student.Model.Student;
import com.demo.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public Page<Student> getStudents(Pageable pageable){
		return studentRepository.findAll(pageable);
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable Long studentId) {
		return studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student Not found with id:"+studentId));
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping("/students/{studentId}")
	public Student updateStudent(@PathVariable Long studentId,@Valid @RequestBody Student studentRequest)
	{
		return studentRepository.findById(studentId)
				.map(student->{
					student.setName(studentRequest.getName());
					return studentRepository.save(student);
				}).orElseThrow(()->new ResourceNotFoundException("Student Not found with id:"+studentId));
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
		return studentRepository.findById(studentId)
				.map(student->{
					studentRepository.delete(student);
					return ResponseEntity.ok().build();
				}).orElseThrow(()->new ResourceNotFoundException("Student Not found with id:"+studentId));
	}
	
}
