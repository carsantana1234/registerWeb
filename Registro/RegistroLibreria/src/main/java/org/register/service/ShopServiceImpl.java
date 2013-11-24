package org.register.service;

import java.util.List;

import javax.annotation.Resource;

import org.register.exception.ShopNotFound;
import org.register.model.Shop;
import org.register.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopRepository shopRepository;

	@Transactional
	public Shop create(Shop shop) {
		Shop createdShop = shop;
		return shopRepository.save(createdShop);
	}

	@Transactional
	public Shop findById(int id) {
		return shopRepository.findOne(id);
	}

	@Transactional(rollbackFor=ShopNotFound.class)
	public Shop delete(int id) throws ShopNotFound {
		Shop deletedShop = shopRepository.findOne(id);

		if (deletedShop == null)
			throw new ShopNotFound();

		shopRepository.delete(deletedShop);
		return deletedShop;
	}

	@Transactional
	public List findAll() {
		return shopRepository.findAll();
	}

	@Transactional(rollbackFor=ShopNotFound.class)
	public Shop update(Shop shop) throws ShopNotFound {
		Shop updatedShop = shopRepository.findOne(shop.getId());

		if (updatedShop == null)
			throw new ShopNotFound();

		updatedShop.setName(shop.getName());
		updatedShop.setEmplNumber(shop.getEmplNumber());
		return updatedShop;
	}

}