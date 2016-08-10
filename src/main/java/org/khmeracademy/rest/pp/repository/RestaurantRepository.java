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
import org.khmeracademy.rest.pp.entity.Menu;
import org.khmeracademy.rest.pp.entity.RestType;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.Telephone;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository {
//	DELETE
	
	@Delete("DELETE FROM rest_restaurant WHERE rest_id=#{id}")
	@SelectKey(statement="SELECT last_value FROM rest_restaurant_rest_id_seq",
	keyProperty="id", keyColumn="last_value", before=false, resultType=int.class)
    int deleteMyObject_Annotation(int id);
	
	String DeleteMenu = "DELETE FROM rest_menu WHERE rest_id=#{my_id}";
	@Delete(DeleteMenu)
	boolean deleteBatch(@Param("my_id") int r_id);
	
	String DeleteImage = "DELETE FROM rest_rest_image WHERE rest_id=#{my_id}";
	@Delete(DeleteImage)
	boolean deleteBatch1(@Param("my_id") int r_id);
	
	String DeleteTelephone = "DELETE FROM rest_telephone WHERE rest_id=#{my_id}";
	@Delete(DeleteTelephone)
	boolean deleteBatch2(@Param("my_id") int r_id);
//	
//	INSERT
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
	
//	
//	Update 
	
	@Update("UPDATE rest_restaurant SET"
			+ "(sub_cat_id=#{sub_id},name=#{name},description=#{desc},delivery=#{delivery},home=#{home},street=#{street},district=#{district},commune=#{commune} "
			+ "WHERE rest_id=#{my_id) ")
    
	@SelectKey(statement="SELECT last_value FROM rest_restaurant_rest_id_seq",
	keyProperty="id", keyColumn="last_value", before=false, resultType=int.class)
    int updateMyObject_Annotation(Restaurant restaurant);
	
	final String updateMenus  = "<script>"
			+ " <foreach  collection='menus' item='menu' separator=','>"
			+ "		UPDTE rest_menu SET "
			+ "							rest_id#{my_id}, "
			+ "							name=#{menu.name}, "
			+ "							url=#{menu.url}"
			+ "	</foreach>"
			+ "</script>";
	@Update(updateMenus)
	boolean updateBatch(@Param("menus") List<Menu>menus,@Param("my_id") int r_id);	
	
	
	final String updateImage  = "<script>"
			+ " <foreach  collection='images' item='image' separator=','>"
			+ "		UPDATE rest_rest_image SET "
			+ "							rest_id=#{my_id}, "
			+ "							url=#{image.url}"
			+ "	</foreach>"
			+ "</script>";
	@Update(updateImage)
	boolean updatetBatch1(@Param("images") List<Images> images,@Param("my_id") int r_id);
	
	
	final String updateTelephones = "<script> "
							+ "	<foreach  collection='telephones' item='telephone' separator=','>"
							+ "		UPDATE rest_telephone"
							+ " 			rest_id=#{my_id},"
							+ "			telephone=#{telephone.tel})"
							+ "			</foreach>"
							+ "</script>";
	@Update(updateTelephones)
	boolean updateBatch2(@Param("telephones") List<Telephone> telephone, @Param("my_id") int r_id);
	
//	selest
	
	@Select("SELECT "
			+ "Rest.rest_id,"
			+ "Rest.sub_id Sub_ID,"
			+"Rest.name Name,"
			+"Rest.description,"
			+"Rest.delivery,"
			+"Rest.home,"
			+"Rest.street,"
			+"Rest.district,"
			+"Rest.commune"
			+ " FROM rest_restaurant Rest "
			+"INNER JOIN rest_rest_image Image ON Image.rest_id = Rest.rest_id"
			+"INNER JOIN rest_menu Menu ON Menu.rest_id = Rest.rest_id"
			+"INNER JOIN rest_telephone Tel ON Tel.rest_id = Rest.rest_id")
//	@Results({
//		@Result(property="id",column="rest_id"),
//		@Result(property="i")
//		@Result(property="name",column="name"),
//	})
	ArrayList<Restaurant> findAll();
//	end select
}
