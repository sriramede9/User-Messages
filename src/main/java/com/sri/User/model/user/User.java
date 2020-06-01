package com.sri.User.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.sri.User.message.Message;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;

	/*
	 * @OneToMany()
	 * 
	 * @JoinTable(name = "User_Messages",joinColumns
	 * = @JoinColumn(name="user_id"),inverseJoinColumns
	 * = @JoinColumn(name="message_id"))
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id",nullable = false)
	private List<Message> usermessage = new ArrayList<Message>();

	public User(int id, String username, String password, List<Message> usermessage) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.usermessage = usermessage;
	}

	public List<Message> getUsermessage() {
		return usermessage;
	}

	public void setUsermessage(List<Message> usermessage) {
		this.usermessage = usermessage;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", usermessage=" + usermessage
				+ "]";
	}

}
