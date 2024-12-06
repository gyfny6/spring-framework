package org.springframework.test.gyf.custemelement;


public class User {

	private String id;
	private String userName;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
