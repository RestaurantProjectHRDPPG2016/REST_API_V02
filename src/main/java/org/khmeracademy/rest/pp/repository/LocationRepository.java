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
			+" FROM rest_locations where type_code!=")
	ArrayList<Location> findAllLocation();
}
