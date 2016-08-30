package org.khmeracademy.rest.pp.service.impl;


import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.User;
import org.khmeracademy.rest.pp.repository.UserLoginRepository;
import org.khmeracademy.rest.pp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
/*	@Override
	public ArrayList<User> findAll() {
		return userLoginRepository.findAll();
	}
*/
	/*@Override
	public boolean save(User user) {
		return userLoginRepository.save(user);
	}

	@Override
	public boolean remove(int id) {
		return userLoginRepository.remove(id);
	}

	@Override
	public boolean update(User user) {
		return userLoginRepository.update(user);
	}*/

	@Override
	public User loadUserByEmail(String email) {
		return userLoginRepository.loadUserByEmail(email);
	}

	@Override
	//TODO: TRANSACTIONAL WITH DATABASE
	@Transactional
	public boolean save(User user) {
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		//TODO: 1. INSERT INTO Member Tables
		userLoginRepository.insertMember(user);
		
		//TODO: 2. INSERT INTO Member Details
		userLoginRepository.saveMemberDetails(user.getRoles(), user.getUser_id());
		
		//TODO: 3. SAVE
		return true;
		
	}
	
	

	@Override
	public ArrayList<User> findMemberAdmin() {
		return userLoginRepository.findMemberAdmin();
	}

	@Override
	public ArrayList<User> findMemberUser() {
		return userLoginRepository.findMemberUser();
	}

//	@Override
//	public boolean save(List<User> users, int m_id) {
//		userLoginRepository.insertMember(users)
//		return userLoginRepository.save(users, m_id);
//	}
	
}
