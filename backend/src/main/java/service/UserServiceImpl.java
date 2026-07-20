package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import entity.User;
import respository.UserRespository;

public class UserServiceImpl implements UserLoginService {

	@Autowired
	UserRespository userRespository;

	@Override
	public boolean userLogin(String userName, String password) {
		List<User> userList = userRespository.findByUserNameAndPassword(userName, password);
		if (!CollectionUtils.isEmpty(userList)) {
			return true;
		}
		return false;
	}

}
