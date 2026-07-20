package service;

import java.util.List;

import models.StudentRequestVO;

public interface StudentService {

	boolean createStudent(StudentRequestVO studentRequestVo);

	List<StudentRequestVO> getAllStudents();

	StudentRequestVO getStudentById(Integer id);

}
