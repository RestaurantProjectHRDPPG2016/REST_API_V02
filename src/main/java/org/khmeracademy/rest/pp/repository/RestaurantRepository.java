package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.entity.Restaurant;
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
	
	@Insert("INSERT INTO rest_brand "
			+ "(naem,desc,delivery,home,street,type,district,commune) "
			+ "VALUES"
			+ " (#{name},#{desc},#{delivery},#{home},#{street},#{type},#{district},#{commune})") 
    	@SelectKey(statement="SELECT nextVal('tbl_brand_brand_id_seq')",
    	keyProperty="id", before=true, resultType=int.class) 
    	int insertMyObject_Annotation(Restaurant restaurant);
	

		
}
