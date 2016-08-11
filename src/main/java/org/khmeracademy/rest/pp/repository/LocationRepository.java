package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository {

//	GET LOCATION
	@Select("SELECT "
			+"id, "
			+"type, "
			+"type_code, "
			+"code, "
			+"khmer_name, "
			+"english_name, "
			+"reference, "
			+"official_note, "
			+"checker_note, "
			+"parent_id "
			+" FROM locations")
	ArrayList<Location> findAllLocation();
//	
//// INSERT LOCATION
//	@Insert("INSERT INTO locations"
//			+ "(id, type, type_code, code, khmer_name, english_name,"
//			+ "reference, official_note, checker_note, parent_id)"
//			+ "VALUES"
//			+ "(#{id}, #{type}, #{type_code}, #{code}, #{khmer_name},"
//			+ "#{english_name}, #{reference}, #{official_note}, #{checker_note}, #{parent_id})")
//	public boolean saveLocation(Location location);
//	
//	
////DELETE LOCATION 
//	@Delete("DELETE FROM locations WHERE id=#{id}")
//	public boolean deleteLocation(int id);
//	
////UPDATE LOCATION
//	@Update("UPDATE locations SET"
//			+ "(id=#{id}, type=#{type}, type_code=#{type_code}, code=#{code},"
//			+ "khmer_code=#{khmer_code}, english_code=#{english_code},"
//			+ "reference=#{reference}, official_note=#{official_note},"
//			+ "checker_note=#{checker_note}, parent_id=#{parent_id}) ")
//	public boolean updateLocation(Location location);
//	
//	
}
