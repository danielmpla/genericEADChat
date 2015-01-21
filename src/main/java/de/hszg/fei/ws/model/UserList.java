package de.hszg.fei.ws.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import java.util.List;

@XmlSeeAlso(User.class)
@XmlRootElement(name = "allUsers")
public class UserList {
	
	private int numUsers;
	
	private List<User> userList;
	
	public int getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(int numUsers) {
		this.numUsers = numUsers;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
