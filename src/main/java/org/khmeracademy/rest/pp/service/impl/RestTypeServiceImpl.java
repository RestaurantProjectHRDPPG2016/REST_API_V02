package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.RestType;
import org.khmeracademy.rest.pp.repository.RestTypeRepository;
import org.khmeracademy.rest.pp.service.RestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestTypeServiceImpl implements RestTypeService{
	@Autowired
	RestTypeRepository restTypeRepository;

	@Override
	public boolean save(RestType restType) {
		return restTypeRepository.save(restType);
	}

	@Override
	public boolean update(RestType restType) {
		return restTypeRepository.update(restType);
	}

	@Override
	public ArrayList<RestType> findAll() {
		return restTypeRepository.findAll();
	}

	@Override
	public boolean remove(int id) {
		return restTypeRepository.remove(id);
	}

}
