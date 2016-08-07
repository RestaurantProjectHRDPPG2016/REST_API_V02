package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.RestType;

public interface RestTypeService {
	boolean remove(int id);
	boolean save(RestType restType);
	boolean update(RestType restType);
	ArrayList<RestType> findAll();
}
