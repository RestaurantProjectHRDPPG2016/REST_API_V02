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
	ArrayList<Location> getAllLocationByParentIdAndTypeCode(int id, String typeCode);
	
	
						@Select("SELECT P.khmer_name, " 
						+" P.id"
						+" FROM rest_locations P"
						+" WHERE P.type_code = '0'")
	ArrayList<Location> getAllCities(int id);
					
						@Select("SELECT D.khmer_name,"
								+" D.id"
								+ " FROM rest_locations P"
								+ " INNER JOIN rest_locations D"
								+ " ON P.id = D.parent_id"
								+ " WHERE D.type_code = '1' AND D.parent_id = #{id}")
	ArrayList<Location> getAllDistrictsByCityId(int id);
	
	@Select(" SELECT C.khmer_name,"
						+" C.id"
						+" FROM rest_locations P"
						+" INNER JOIN rest_locations D"
						+" ON P.id = D.parent_id"
						+" INNER JOIN rest_locations C"
						+" ON D.id = C.parent_id"
						+" WHERE C.type_code = '2' AND C.parent_id =#{id}")
	ArrayList<Location> getAllCommuneByDistrictID(int id);
	
	
					@Select("SELECT V.khmer_name,"
					+" V.id"
					+" FROM rest_locations"
					+" P INNER"
					+" JOIN rest_locations"
					+" D ON P.id= D.parent_id "
					+ " INNER JOIN rest_locations"
					+" C ON D.id= C.parent_id INNER"
					+" JOIN rest_locations"
					+" V ON C.id=V.parent_id WHERE V.type_code='3'"
					+" AND V.parent_id=#{id}")
			ArrayList<Location> getAllVillageByCommuneID(int id);
 }
