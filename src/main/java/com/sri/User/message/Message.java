package com.sri.User.message;

import java.util.Date;

public class Message {

	private int messageid;
	private String message;
	private Date datecreated;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int messageid, String message, Date datecreated) {
		super();
		this.messageid = messageid;
		this.message = message;
		this.datecreated = datecreated;
	}

	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	@Override
	public String toString() {
		return "Message [messageid=" + messageid + ", message=" + message + ", datecreated=" + datecreated + "]";
	}
	
	
	
}
