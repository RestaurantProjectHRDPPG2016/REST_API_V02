package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.repository.MainCategoryRepository;
import org.khmeracademy.rest.pp.service.MainCategoryService;
import org.khmeracademy.rest.pp.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MainCategoryServiceImpl implements MainCategoryService {
	@Autowired
	private MainCategoryRepository mainCategoryRepository;
	@Override
	public boolean remove(int id) {
		return mainCategoryRepository.remove(id);
	}

	@Override
	public boolean save(MainCategory mainCategory) {
		return mainCategoryRepository.save(mainCategory);
	}

	@Override
	public boolean update(MainCategory mainCategory) {
		return mainCategoryRepository.update(mainCategory);
	}

	@Override
	public ArrayList<MainCategory> findAll(Pagination pagination) {
		pagination.setTotalCount(mainCategoryRepository.totalCount());
		return mainCategoryRepository.findAll(pagination);
	}

	@Override
	public ArrayList<MainCategory> findAll() {
		return mainCategoryRepository.findAllWithoutPagination();
	}

	@Override
	public long totalCount() {
		return mainCategoryRepository.totalCount();
	}
	
	

}
