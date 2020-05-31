package com.sri.User.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.sri.User.message.Message;
import com.sri.User.model.user.User;
import com.sri.User.model.user.UserDaoService;
import com.sri.User.model.user.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

//	List<User> listofusers=new ArrayList<User>();

	@Autowired
	private UserRepository userRepository;

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

		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getaUser(@PathVariable("id") int id) {
		User user = userService.getUserbyId(id);

		if (user == null) {
			throw new UserNotFoundException("No such user found with given Id \t" + id);
		}
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User u) {

		User addUser = userService.AddUser(u);
//      URI createdLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addUser.getId()).toUri();

		URI createdLocation = ServletUriComponentsBuilder.fromCurrentContextPath().path("user/{id}")
				.buildAndExpand(addUser.getId()).toUri();

		User save = userRepository.save(u);

		System.out.println(save);

		return ResponseEntity.created(createdLocation).build();

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		User deleteUser = userService.deleteUser(id);
		if (deleteUser == null) {
			throw new UserNotFoundException("No such user found with given Id \t" + id);
		}
		return new ResponseEntity<User>(deleteUser, HttpStatus.OK);
	}

	@GetMapping("{id}/messages/all")
	public ResponseEntity<List<Message>> userComments(@PathVariable("id") int id) {
		List<Message> userMessagesbyId = userService.getUserMessagesbyId(id);

		return new ResponseEntity<List<Message>>(userMessagesbyId, HttpStatus.FOUND);

	}

	@GetMapping("{id}/messages/{messageid}")
	public ResponseEntity<Message> usercommentsbymessageid(@PathVariable("id") int userid,
			@PathVariable("messageid") int messageid) {
		Message userMessagebyMessageId = userService.getUserMessagebyMessageId(userid, messageid);

		return new ResponseEntity<Message>(userMessagebyMessageId, HttpStatus.FOUND);
	}

	@PostMapping("{userid}/messages/addmessage")
	public String addMessage(@PathVariable("userid") int id, @RequestBody Message message) {
		userService.addMessage(id, message);

		return "redirect:/{userid}/messages/all";
	}

}
