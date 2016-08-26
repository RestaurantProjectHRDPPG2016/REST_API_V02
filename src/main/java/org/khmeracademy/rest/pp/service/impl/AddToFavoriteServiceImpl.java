package org.khmeracademy.rest.pp.service.impl;

import org.khmeracademy.rest.pp.entity.AddToFavorite;
import org.khmeracademy.rest.pp.repository.AddToFavoriteRepository;
import org.khmeracademy.rest.pp.service.AddToFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AddToFavoriteServiceImpl implements AddToFavoriteService {
	@Autowired 
	private AddToFavoriteRepository addToFavoriteRepository;
	@Override
	public boolean save(AddToFavorite addToFavorite) {
		return addToFavoriteRepository.save(addToFavorite) ;
	}

	@Override
	public boolean remove(int id) {
		return addToFavoriteRepository.remove(id);
	}

	@Override
	public AddToFavorite findOne() {
		return null;
	}

}
