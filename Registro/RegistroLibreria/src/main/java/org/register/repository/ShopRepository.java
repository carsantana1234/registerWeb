package org.register.repository;


import org.register.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ShopRepository extends JpaRepository<Shop, Integer> {

}