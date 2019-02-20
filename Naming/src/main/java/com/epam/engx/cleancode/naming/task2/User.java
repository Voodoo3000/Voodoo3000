package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date birthDate;

	private String username;

	private boolean adminStatus;

	private User[] subordinateArray;

	private int rating;

	public User(String name) {
		super();
		this.username = name;
	}

	@Override
	public String toString() {
		return "User [birthDate=" + birthDate + ", username=" + username + ", adminStatus=" + adminStatus + ", subordinateArray="
				+ Arrays.toString(subordinateArray) + ", rating=" + rating + "]";
	}

}
