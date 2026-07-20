package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import entity.Student;
import mapper.StudentMapper;
import models.StudentRequestVO;
import respository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public boolean createStudent(StudentRequestVO studentRequestVo) {
		if (!ObjectUtils.isEmpty(studentRequestVo)) {
			Student student = studentMapper.mapStudent(studentRequestVo);
			if (studentRequestVo.getId() == null) {
				student.setId(getLatestId());
			}
			studentRepository.save(student);
			return true;
		}

		return false;
	}

	private Integer getLatestId() {
		Integer value = studentRepository.findlatestId();
		if (value == null) {
			return 1;
		}
		return value + 1;
	}

	@Override
	public List<StudentRequestVO> getAllStudents() {
		List<StudentRequestVO> studentList = new ArrayList<>();
		List<Student> students = studentRepository.findAll();
		if (!CollectionUtils.isEmpty(students)) {
			for (Student student : students) {
				studentList.add(studentMapper.mapStudentVo(student));
			}
		}
		return studentList;

	}

	@Override
	public StudentRequestVO getStudentById(Integer id) {
		StudentRequestVO studentVo = null;
		Optional<Student> stundent = studentRepository.findById(id);
		if (stundent.isPresent()) {
			studentVo = studentMapper.mapStudentVo(stundent.get());
		}

		return studentVo;
	}
}
