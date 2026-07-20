package mapper;

import org.mapstruct.Mapper;

import entity.Student;
import models.StudentRequestVO;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	Student mapStudent(StudentRequestVO studentRequestVO);
	
	StudentRequestVO mapStudentVo(Student student);
}
