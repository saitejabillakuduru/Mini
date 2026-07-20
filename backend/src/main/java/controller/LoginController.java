package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.UserLoginService;

@RestController
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserLoginService userLoginService;

	@GetMapping("/{userName}/{password}")
	public ResponseEntity<?> checkUserDetails(@PathVariable String userName, @PathVariable String password) {

		boolean status = userLoginService.userLogin(userName, password);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
