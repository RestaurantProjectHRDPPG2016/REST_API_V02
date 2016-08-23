package org.khmeracademy.rest.pp.service;


import org.khmeracademy.rest.pp.entity.User;

public interface UserLoginService {

/*	ArrayList<User> findAll();*/
	/*boolean save(User user);
	boolean remove(int id);
	boolean update(User user);*/
	User loadUserByEmail(String email);
	
}
