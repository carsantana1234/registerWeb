package org.register.service;

import java.util.List;

import org.register.exception.ShopNotFound;
import org.register.model.Shop;


public interface ShopService {

	public Shop create(Shop shop);
	public Shop delete(int id) throws ShopNotFound;
	public List findAll();
	public Shop update(Shop shop) throws ShopNotFound;
	public Shop findById(int id);

}