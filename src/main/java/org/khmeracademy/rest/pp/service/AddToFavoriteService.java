package org.khmeracademy.rest.pp.service;

import org.khmeracademy.rest.pp.entity.AddToFavorite;

public interface AddToFavoriteService {
	boolean save(AddToFavorite addToFavorite);
	boolean remove(int id);
	AddToFavorite findOne();
}
