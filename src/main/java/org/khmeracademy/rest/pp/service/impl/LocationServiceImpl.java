package org.khmeracademy.rest.pp.service.impl;

import java.util.List;

import org.khmeracademy.rest.pp.entity.Location;
import org.khmeracademy.rest.pp.repository.LocationRepository;
import org.khmeracademy.rest.pp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<Location> getAllCities() {
		try{
			return locationRepository.getAllCities(0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Location> getAllDistrictsByCityId(int cityId) {
		try{
			return locationRepository.getAllDistrictsByCityId(cityId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Location> getAllCommunesByDistrictById(int districtId) {
		try{
			return locationRepository.getAllCommuneByDistrictID(districtId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Location> getAllVillagesByCommuneId(int communeId) {
		try{
			return locationRepository.getAllVillageByCommuneID(communeId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

	}
	
