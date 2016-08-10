package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.RestType;
import org.khmeracademy.rest.pp.entity.SubCategory;

public interface SubCategoryService {
	boolean remove(int id);
	boolean save(SubCategory subCategory);
	boolean update(SubCategory subCategory);
	ArrayList<SubCategory> findAll();
}
