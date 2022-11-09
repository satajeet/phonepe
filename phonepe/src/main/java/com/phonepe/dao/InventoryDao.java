package com.phonepe.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phonepe.entity.Inventory;

@Repository
public interface InventoryDao extends CrudRepository<Inventory, String> {

}
