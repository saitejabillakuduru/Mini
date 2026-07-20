package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.StudentRequestVO;
import service.StudentService;

@RestController
@RequestMapping("/stundent")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/")
	public ResponseEntity<?> createStudent(@RequestBody StudentRequestVO studentRequestVO) {
		if (ObjectUtils.isEmpty(studentRequestVO)) {
			return new ResponseEntity<>("Request is empty", HttpStatus.BAD_REQUEST);
		}
		boolean status = studentService.createStudent(studentRequestVO);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllStudents() {
		List<StudentRequestVO> studentsList = studentService.getAllStudents();
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
		StudentRequestVO studentsList = studentService.getStudentById(id);
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> updateStudent(@RequestBody StudentRequestVO studentRequestVO) {
		boolean status = studentService.createStudent(studentRequestVO);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
