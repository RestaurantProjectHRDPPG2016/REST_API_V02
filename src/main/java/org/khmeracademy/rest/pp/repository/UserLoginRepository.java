package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.Role;
import org.khmeracademy.rest.pp.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository {

	@Select("SELECT * FROM rest_member WHERE email=#{email}")
	@Results({
		@Result(property="user_id", column="m_id"),
		@Result(property="username", column="name"),
		@Result(property="password", column="password"),
		@Result(property="email", column="email"),
		@Result(property="status", column="status"),
		@Result(property="roles", column="m_id", many=@Many(select="findUserByUserID"))
	})
	public User loadUserByEmail(@Param("email") String email);
	
	
	
	@Select("SELECT * FROM rest_role WHERE role_id=#{role_id}")
	@Results({
			@Result(property="role_id",column="role_id"),
			@Result(property="role_name",column="role_name")
	})
	public List<Role> findUserByUserID(@Param("role_id") int role_id);
	
	
	
	/*
	@Insert("INSERT INTO rest_member"
			+ "( name, email, password, status, role)"
			+ "VALUES"
			+ "(#{name}, #{email}, #{password}, #{status}, #{role})")
	boolean save(User user);*/
	
	/*@Delete("DELETE FROM rest_member WHERE m_id=#{m_id}")
	boolean remove(int id);
	
	@Update("UPDATE rest_member SET"
			+ "name=#{name}, email=#{email}, password=#{password},"
			+ " status=#{status}, role=#{role} WHERE m_id=#{m_id}")
	boolean update(User user);
	*/
}
