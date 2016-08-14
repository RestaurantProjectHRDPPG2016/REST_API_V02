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
import org.khmeracademy.rest.pp.entity.Images;
import org.khmeracademy.rest.pp.entity.Menu;
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
	boolean deleteMenu(@Param("my_id") int r_id);
	
	String DeleteImage = "DELETE FROM rest_rest_image WHERE rest_id=#{my_id}";
	@Delete(DeleteImage)
	boolean deleteImage(@Param("my_id") int r_id);
	
	String DeleteTelephone = "DELETE FROM rest_telephone WHERE rest_id=#{my_id}";
	@Delete(DeleteTelephone)
	boolean deleteTelephone(@Param("my_id") int r_id);
//	
//	INSERT
	@Insert("INSERT INTO rest_restaurant "
			+ "(c_id,name,description,delivery,home,street,province,district,commune) "
			+ "VALUES"
			+ " (#{sub_id},#{name},#{desc},#{delivery},#{home},#{street},#{province},#{district},#{commune})") 
    
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
	boolean insertMenu(@Param("menus") List<Menu>menus,@Param("my_id") int r_id);	
	
	final String Images = "<script> "
			+ "		INSERT INTO rest_rest_image (rest_id, "
			+ "								 url) "
			+ "		VALUES "
			+ "			<foreach  collection='images' item='image' separator=','>"
			+ "				(#{my_id}, #{image.url})"
			+ "			</foreach>"
			+ "</script>";
	@Insert(Images)
	boolean insertImage(@Param("images") List<Images> images,@Param("my_id") int r_id);
	
	
	final String Telephones = "<script> "
							+ "		INSERT INTO rest_telephone (rest_id, "
							+ "								 telephone) "
							+ "		VALUES "
							+ "			<foreach  collection='telephones' item='telephone' separator=','>"
							+ "				(#{my_id}, #{telephone.tel})"
							+ "			</foreach>"
							+ "</script>";
	@Insert(Telephones)
	boolean insertTelephone(@Param("telephones") List<Telephone> telephone, @Param("my_id") int r_id);
	
//	
//	Update 
	
	@Update("UPDATE rest_restaurant SET"
			+ "(c_id=#{sub_id},name=#{name},description=#{desc},delivery=#{delivery},home=#{home},street=#{street},province=#{province},district=#{district},commune=#{commune} "
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
	boolean updateMenu(@Param("menus") List<Menu>menus,@Param("my_id") int r_id);	
	
	
	final String updateImage  = "<script>"
			+ " <foreach  collection='images' item='image' separator=','>"
			+ "		UPDATE rest_rest_image SET "
			+ "							rest_id=#{my_id}, "
			+ "							url=#{image.url}"
			+ "	</foreach>"
			+ "</script>";
	@Update(updateImage)
	boolean updatetImage(@Param("images") List<Images> images,@Param("my_id") int r_id);
	
	
	final String updateTelephones = "<script> "
							+ "	<foreach  collection='telephones' item='telephone' separator=','>"
							+ "		UPDATE rest_telephone"
							+ " 			rest_id=#{my_id},"
							+ "			telephone=#{telephone.tel})"
							+ "			</foreach>"
							+ "</script>";
	@Update(updateTelephones)
	boolean updateTelephone(@Param("telephones") List<Telephone> telephone, @Param("my_id") int r_id);
	
//	selest
	
	@Select("SELECT "
			+ "Rest.rest_id, "
			+ "Rest.c_id, "
			+ "Rest.name, "
			+ "Rest.description, "
			+ "Rest.delivery, "
			+ "Rest.home, "
			+ "Rest.street, "
			+ "Rest.province, "
			+ "Rest.district, "
			+ "Rest.commune, "
			+ "Rest.create_date "
			+ " FROM rest_restaurant Rest ")
	@Results({
		@Result(property="id",column="rest_id"),
		@Result(property="sub_id",column="c_id"),
		@Result(property="name",column="name"),
		@Result(property="desc",column="description"),
		@Result(property="delivery",column="delivery"),
		@Result(property="home",column="home"),
		@Result(property="street",column="street"),
		@Result(property="province",column="province"),
		@Result(property="district",column="district"),
		@Result(property="commune",column="commune"),
		@Result(property="create_date",column="create_date"),
		@Result(property="images", column="rest_id", many = @Many(select = "findImage")),
		@Result(property="menus", column="rest_id", many = @Many(select = "findMenu")),
		@Result(property="telephone", column="rest_id", many=@Many(select = "findTelephone"))
	})
	ArrayList<Restaurant> findAll();
	
	@Select("SELECT rest_img_id,rest_id, url FROM rest_rest_image WHERE rest_id=#{rest_id}")
	@Results(value = {
		@Result(property="id" , column="rest_img_id"),
		@Result(property="r_id" , column="rest_id"),
		@Result(property="url" , column="url")
	})
	public List<Images> findImage( int rest_id);
	
	
	@Select("SELECT menu_id,rest_id,name, url FROM rest_menu WHERE rest_id=#{rest_id}")
	@Results(value = {
		@Result(property="id" , column="menu_id"),
		@Result(property="r_id" , column="rest_id"),
		@Result(property="name", column="name"),
		@Result(property="url" , column="url")
	})
	public List<Menu> findMenu( int rest_id);
	
	@Select("SELECT tel_id,rest_id,telephone FROM rest_telephone WHERE rest_id=#{rest_id}")
	@Results(value = {
		@Result(property="id" , column="menu_id"),
		@Result(property="r_id" , column="rest_id"),
		@Result(property="tel", column="telephone")
	})
	public List<Telephone> findTelephone( int rest_id);
	
//	end select
}
