package com.sri.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.User.model.user.User;
import com.sri.User.model.user.UserDaoService;

@RestController
@RequestMapping("/user")
public class UserController {
	
//	List<User> listofusers=new ArrayList<User>();

	@Autowired
	private UserDaoService userService;
	
//	 @PostConstruct
//	    public void init(){
//	        // start your monitoring in here
//		 listofusers.add(new User(1,"sri","sri"));
//		 listofusers.add(new User(2,"sri2","sri2"));
//		 listofusers.add(new User(1,"sri3","sri3"));		 
//	    }

	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers() {
		
		return new ResponseEntity<List<User>>( userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getaUser(@PathVariable("id") int id) {
		User user=userService.getUserbyId(id);
		return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User u) {
		
      userService.AddUser(u);
		
      return new ResponseEntity<User>(u,HttpStatus.CREATED);
		
	}
	
}
