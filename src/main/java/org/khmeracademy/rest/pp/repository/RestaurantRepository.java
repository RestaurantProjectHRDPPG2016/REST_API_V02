package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

@Repository
public interface RestaurantRepository {
	@Delete("DELETE FROM rest_brand WHERE brand_id=#{id}")
	boolean remove(int id);
//	@Update("UPDATE rest_brand SET "
//			+ "name=#{name}, "
//			+ "desc=#{desc},"
//			+ "delivery=#{delivery},"
//			+ "home=#{home},"
//			+ "street=#{street},"
//			+ "type=#{type},"
//			+ "district=#{district},"
//			+ "commune=#{commune},"
//			+ "tel=#{tel},"
//			+ "img=#{img},"
//			+ "menu=#{menu}"
//			+ " WHERE brand_id=#{id}")
//	boolean update(MainCategory mainCategory);
//	@Insert("INSERT INTO rest_brand"
//			+ "(naem,desc,delivery,home,street,type,district,commune,tel,img,menu) "
//			+ "VALUES (#{name},#{desc},#{delivery},#{home},#{street},#{type},#{district},#{commune},#{tel},#{img},#{menu})")
//	boolean save(MainCategory mainCategory);
//	@Select("SELECT c_id,c_name,c_img1,c_img2 FROM rest_categories ORDER BY c_id DESC")
//	@Results({
//		@Result(property="id",column="c_id"),
//		@Result(property="name",column="c_name"),
//		@Result(property="img1",column="c_img1"),
//		@Result(property="img2",column="c_img2")
//	})
//	ArrayList<MainCategory> findAll();
	
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
			+ "			<foreach  collection='menu' item='menu' separator=','>"
			+ "				(#{r_id}, #{name}, #{url})"
			+ "			</foreach>"
			+ "</script>";
	boolean insertBatch(List<Menu>menus);	
	final String Images = "<script>"
			+"INSERT INTO rest_rest_image (rest_id,"
			+"url"
			+"VALUSE"
			+"<froeach collection = 'rest_images' item='rest_image' separator=','>"
			+"(#{r_id},#{url}"
			+"</foreach>"
			+"<script>";
	boolean insertBatch1(List<Images> images);
	final String Telephones ="<script>"
			+"INSERT INTO rest_telephone"
			+"(rest_id,"
			+"telephone"
			+"VALUES"
			+"<foreach collection = ' res_telephone' item='rest_telephone' separator=','>"
			+"(#{r_id},#{telephone}"
			+"</foreach>"
			+"<script>";
	boolean insertBatch2(List<Telephone>telephone);
}
