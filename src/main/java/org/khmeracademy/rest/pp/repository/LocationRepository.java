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
			+" FROM rest_locations")
	ArrayList<Location> findAllLocation();

	@Select("SELECT"
					+"khmer_name"
					+" FROM rest_locations"
					+"where type_code='0'")
			ArrayList<Location> findProvince();

	@Select("SELECT"
			+"khmer_name"
			+" FROM rest_location"
			+" WHERE type_code='1'")
		ArrayList<Location> findDistrict();

	@Select("SELECT"
		+"khmer_name"
		+" FROM rest_location"
		+" WHERE type_code='2'")
		ArrayList<Location> findCommune();

}
