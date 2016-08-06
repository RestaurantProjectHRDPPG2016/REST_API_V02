package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.MainCategory;
import org.springframework.stereotype.Service;

public interface MainCategoryService {
	boolean remove(int id);
	boolean save(MainCategory mainCategory);
	boolean update(MainCategory mainCategory);
	ArrayList<MainCategory> findAll();
}
