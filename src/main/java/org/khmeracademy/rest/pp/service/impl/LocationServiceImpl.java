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
		locationRepository.findAllLocation();
		return null;
	}

	@Override
	public boolean saveLocation(Location location) {
		locationRepository.saveLocation(location);
		return false;
	}

	@Override
	public boolean deleteLocation(int id) {
		locationRepository.deleteLocation(id);
		return false;
	}

	@Override
	public boolean updateLocation(Location location) {
		locationRepository.updateLocation(location);
		return false;
	}

	
	
}
