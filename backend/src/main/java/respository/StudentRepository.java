package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query(value =  "SELECT MAX(id) FROM student",nativeQuery = true)
	Integer findlatestId();

}
