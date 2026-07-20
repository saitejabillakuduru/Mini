package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.User;
import java.util.List;


@Repository
public interface UserRespository extends JpaRepository<User, Integer>{
	
	List<User> findByUserNameAndPassword(String userName, String password);

}
