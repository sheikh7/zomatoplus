package com.thinkxfactor.zomatoplus.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository ;

	
	//
	//	@GetMapping("/login")
	//	public String userLogin() {
	//		return "Hello from thinkxfactor";
	//	}

	@PostMapping("/login")
	public User user_login(@RequestBody User user) {
		User usr =userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		
		return usr;
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		User persistedUser=userRepository.save(user);
		return persistedUser;
		
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		List<User> listofusers=userRepository.findAll();
		return listofusers;
	}

	@PostMapping("/create")
	User diffUser(@RequestBody User user) {
		System.out.println(user.toString());
		return user;
	}
	
}
