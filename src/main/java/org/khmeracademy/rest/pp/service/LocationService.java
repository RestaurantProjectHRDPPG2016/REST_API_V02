package org.khmeracademy.rest.pp.service;

import java.util.List;

import org.khmeracademy.rest.pp.entity.Location;

public interface LocationService {
	
	List<Location> getAllCities();
	
	List<Location> getAllDistrictsByCityId(int cityId);
	
	List<Location> getAllCommunesByDistrictById(int districtId);
	
	List<Location> getAllVillagesByCommuneId(int communeId);
	
}
