package com.sri.User.model.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.sri.User.message.Message;

@Service
public class UserDaoService {

	private static List<User> listofusers = new ArrayList<User>();

	static {
	List<Message>	listofmessages=new ArrayList<Message>();
	listofmessages.add(new Message(1,"u1",new Date()));
		listofusers.add(new User(1, "sri", "sri", listofmessages));
		listofusers
				.add(new User(2, "sri2", "sri2", Arrays.asList(new Message(1, "This is firstMessage u2", new Date()))));
		listofusers
				.add(new User(3, "sri3", "sri3", Arrays.asList(new Message(1, "This is firstMessage u3", new Date()))));
	}

	public List<User> getAllUsers() {
		return this.listofusers;
	}

	public User getUserbyId(int id) {
		for (User u : listofusers) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public User AddUser(User user) {
		user.setId(listofusers.size() + 1);
		listofusers.add(user);
		return user;
	}

	public List<Message> getUserMessagesbyId(int id) {

		for (User u : listofusers) {
			if (u.getId() == id) {
				return u.getUsermessage();
			}
		}
		return null;
	}

	public Message getUserMessagebyMessageId(int userid, int messageid) {
		for (User u : listofusers) {
			if (u.getId() == userid) {
				for (Message m : u.getUsermessage()) {
					if (m.getMessageid() == messageid) {
						return m;
					}
				}

			}
		}
		return null;
	}
	
	public void addMessage(int userid,Message message) {
		
		for(User u:listofusers) {
			if(u.getId()==userid) {
				message.setMessageid(u.getUsermessage().size()+1);
//				List<Message> usermessage = u.getUsermessage() ; 
				u.getUsermessage().add(message);
//				System.out.println(message);
			}
		}
	}
}
