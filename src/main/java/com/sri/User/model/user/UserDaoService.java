package com.sri.User.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	private static List<User> listofusers =new ArrayList<User>();
	
	static {
		 listofusers.add(new User(1,"sri","sri"));
		 listofusers.add(new User(2,"sri2","sri2"));
		 listofusers.add(new User(3,"sri3","sri3"));
	}
	
	public List<User> getAllUsers(){
		return this.listofusers;
	}
	
	public User getUserbyId(int id) {
		 User u=null;
		 return  listofusers.stream().filter(x->x.getId()==id).findAny().get();
	}
	
	public User AddUser(User user) {
		user.setId(listofusers.size()+1);
		listofusers.add(user);
		return user;
	}
}
