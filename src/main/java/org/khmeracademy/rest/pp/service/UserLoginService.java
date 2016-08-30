package org.khmeracademy.rest.pp.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.khmeracademy.rest.pp.entity.User;

public interface UserLoginService {

	ArrayList<User> findMemberAdmin();
	ArrayList<User> findMemberUser();
	/*boolean remove(int id);
	 * boolean save(@Param("users") List<User>users,@Param("m_id") int m_id);
	boolean update(User user);*/
	User loadUserByEmail(String email);
	boolean save(User user);
	
}
