package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

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
	public ArrayList<Location> findAllLocation() {
		return locationRepository.findAllLocation();
	}

//	@Override
//	public boolean saveLocation(Location location) {
//		return locationRepository.saveLocation(location);
//	}
//
//	@Override
//	public boolean deleteLocation(int id) {
//		return locationRepository.deleteLocation(id);
//	}
//
//	@Override
//	public boolean updateLocation(Location location) {
//		return locationRepository.updateLocation(location);
//	}

	
	
}
