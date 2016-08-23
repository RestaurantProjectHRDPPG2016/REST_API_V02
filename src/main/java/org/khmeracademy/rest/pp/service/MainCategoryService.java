package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.utilities.Pagination;
import org.springframework.stereotype.Service;

public interface MainCategoryService {
	boolean remove(int id);
	boolean save(MainCategory mainCategory);
	boolean update(MainCategory mainCategory);
	ArrayList<MainCategory> findAll(Pagination pagination);
	public ArrayList<MainCategory> findAll();
	long totalCount();
}
