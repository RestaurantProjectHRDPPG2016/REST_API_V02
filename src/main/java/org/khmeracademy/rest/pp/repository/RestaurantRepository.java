package org.khmeracademy.rest.pp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.khmeracademy.rest.pp.entity.Images;
import org.khmeracademy.rest.pp.entity.Menu;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.Telephone;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository {
	@Delete("DELETE FROM rest_brand WHERE brand_id=#{id}")
	boolean remove(int id);
	
	@Insert("INSERT INTO rest_restaurant "
			+ "(sub_cat_id,name,description,delivery,home,street,district,commune) "
			+ "VALUES"
			+ " (#{sub_id},#{name},#{desc},#{delivery},#{home},#{street},#{district},#{commune})") 
    
	@SelectKey(statement="SELECT last_value FROM rest_restaurant_rest_id_seq",
	keyProperty="id", keyColumn="last_value", before=false, resultType=int.class)
    int insertMyObject_Annotation(Restaurant restaurant);
	
	final String Menus  = "<script>"
			+ "		INSERT INTO rest_menu (rest_id, "
			+ "								 name, "
			+ "								url)"
			+ "		VALUES "
			+ "			<foreach  collection='menus' item='menu' separator=','>"
			+ "				(#{my_id}, #{menu.name}, #{menu.url})"
			+ "			</foreach>"
			+ "</script>";
	@Insert(Menus)
	boolean insertBatch(@Param("menus") List<Menu>menus,@Param("my_id") int r_id);	
	
	final String Images = "<script> "
			+ "		INSERT INTO rest_rest_image (rest_id, "
			+ "								 url) "
			+ "		VALUES "
			+ "			<foreach  collection='images' item='image' separator=','>"
			+ "				(#{my_id}, #{image.url})"
			+ "			</foreach>"
			+ "</script>";
	@Insert(Images)
	boolean insertBatch1(@Param("images") List<Images> images,@Param("my_id") int r_id);
	
	
	final String Telephones = "<script> "
							+ "		INSERT INTO rest_telephone (rest_id, "
							+ "								 telephone) "
							+ "		VALUES "
							+ "			<foreach  collection='telephones' item='telephone' separator=','>"
							+ "				(#{my_id}, #{telephone.tel})"
							+ "			</foreach>"
							+ "</script>";
	@Insert(Telephones)
	boolean insertBatch2(@Param("telephones") List<Telephone> telephone, @Param("my_id") int r_id);
}
