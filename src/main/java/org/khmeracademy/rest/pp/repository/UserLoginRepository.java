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
import org.apache.ibatis.annotations.SelectKey;
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
	
	
	
	@Select("SELECT * FROM rest_role r INNER JOIN rest_user_detail rd  "
			+ "ON r.role_id = rd.role_id "
			+ "WHERE rd.m_id=#{m_id}")
	@Results({
			@Result(property="role_id",column="role_id"),
			@Result(property="role_name",column="role_name")
	})
	public List<Role> findUserByUserID(@Param("role_id") int role_id);
	
	@Select("SELECT "
			+ "M.m_id,"
			+ "M.name, "
			+ "M.email, "
			+ "M.gender, "
			+ "M.phone, "
			+ "M.address, "
			+ "M.status, "
			+ "U.role_id FROM "
			+ "rest_user_detail U "
			+ "INNER JOIN rest_member M "
			+ "ON U.m_id = M.m_id "
			+ "INNER JOIN rest_role R "
			+ "ON U.role_id = R.role_id "
			+ "WHERE U.role_id='1' AND M.status='T'")
	@Results({
		@Result(property="user_id", column="m_id"),
		@Result(property="username", column="name"),
		@Result(property="email", column="email"),
		@Result(property="gender", column="gender"),
		@Result(property="phone", column="phone"),
		@Result(property="address", column="address"),
		@Result(property="status", column="status")
	})
	ArrayList<User> findMemberAdmin();
	
	
	@Select("SELECT "
			+ "M.m_id,"
			+ "M.name, "
			+ "M.email, "
			+ "M.gender, "
			+ "M.phone, "
			+ "M.address, "
			+ "M.status, "
			+ "U.role_id FROM "
			+ "rest_user_detail U "
			+ "INNER JOIN rest_member M "
			+ "ON U.m_id = M.m_id "
			+ "INNER JOIN rest_role R "
			+ "ON U.role_id = R.role_id "
			+ "WHERE U.role_id='2' AND M.status='T'")
	@Results({
		@Result(property="user_id", column="m_id"),
		@Result(property="username", column="name"),
		@Result(property="email", column="email"),
		@Result(property="gender", column="gender"),
		@Result(property="phone", column="phone"),
		@Result(property="address", column="address"),
		@Result(property="status", column="status")
	})
	ArrayList<User> findMemberUser();
	
	
	
	
	@Insert("INSERT INTO rest_member "
			+ "(name,gender,email,password,phone,address,status) "
			+ "VALUES"
			+ " (#{username},#{gender},#{email},#{password},#{phone},#{address},#{status})") 
    			
	@SelectKey(statement="SELECT last_value FROM rest_member_m_id_seq ", keyProperty="user_id", keyColumn="last_value", before=false, resultType=int.class)
    int insertMember(User users);

	final String User  = "<script>"
			+ "		INSERT INTO rest_user_detail (role_id, m_id)"
			+ "		VALUES "
			+ "			<foreach  collection='roles' item='role' separator=','>"
			+ "				(#{role.role_id}, #{m_id})"
			+ "			</foreach>"
			+ "</script>";
	@Insert(User)
	boolean saveMemberDetails(@Param("roles") List<Role> roles,@Param("m_id") int m_id);
	
}
