package org.khmeracademy.rest.pp.service.impl;


import org.khmeracademy.rest.pp.entity.User;
import org.khmeracademy.rest.pp.repository.UserLoginRepository;
import org.khmeracademy.rest.pp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
	public boolean save(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return false;
	}
	
}
