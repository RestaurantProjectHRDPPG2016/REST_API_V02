package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.Images;
import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.entity.Menu;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.Telephone;
import org.springframework.stereotype.Repository;

import scala.annotation.meta.param;

@Repository
public interface RestaurantRepository {
	@Delete("DELETE FROM rest_brand WHERE brand_id=#{id}")
	boolean remove(int id);
	
	@Insert("INSERT INTO rest_restaurant "
			+ "(name,description,delivery,home,street,district,commune) "
			+ "VALUES"
			+ " (#{name},#{desc},#{delivery},#{home},#{street},#{district},#{commune})") 
    
	@SelectKey(statement="SELECT last_value FROM rest_restaurant_rest_id_seq",
	keyProperty="id", keyColumn="last_value", before=false, resultType=int.class)
    	int insertMyObject_Annotation(Restaurant restaurant);
	
	final String menues  = "<script>"
			+ "		INSERT INTO rest_menu (rest_id, "
			+ "								 name, "
			+ "								url"
			+ "		VALUES "
			+ "			<foreach  collection='menus' item='menu' separator=','>"
			+ "				(#{r_id}, #{menu.name}, #{menu.url})"
			+ "			</foreach>"
			+ "</script>";
	boolean insertBatch(@Param("menus") List<Menu>menus,@Param("r_id") int r_id);	
	final String Images = "<script>"
			+"INSERT INTO rest_rest_image (rest_id,"
			+" url"
			+" VALUES "
			+" <froeach collection = 'rest_images' item='image' separator=','>"
			+" (#{r_id},#{imgage.url}"
			+" </foreach>"
			+" <script>";
	boolean insertBatch1(@Param("iamges") List<Images> images,@Param("r_id") int r_id);
	final String Telephones ="<script>"
			+"INSERT INTO rest_telephone"
			+"(rest_id,"
			+"telephone"
			+"VALUES"
			+"<foreach collection = ' res_telephone' item='telephone' separator=','>"
			+"(#{r_id},#{telephone.telephone}"
			+"</foreach>"
			+"<script>";
	boolean insertBatch2(@Param("telephone")List<Telephone>telephone,@Param("r_id")int r_id);
}
