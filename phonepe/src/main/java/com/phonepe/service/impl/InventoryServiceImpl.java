package com.phonepe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonepe.dao.InventoryDao;
import com.phonepe.entity.Inventory;
import com.phonepe.service.InventoryService;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDao inventoryDao;

    @Override
    public String addInventory(Inventory inventory) {
	Optional<Inventory> optional = inventoryDao.findById(inventory.getProductId());
	if (optional.isPresent()) {
	    Inventory inventoryUpdate = optional.get();
	    inventoryUpdate.setAmount(inventoryUpdate.getAmount() + inventory.getAmount());
	    inventoryDao.save(inventoryUpdate);
	} else {
	    inventoryDao.save(inventory);
	}
	return "ok";
    }

    @Override
    public String removeInventory(String productId) {
	Optional<Inventory> optional = inventoryDao.findById(productId);
	if (optional.isPresent()) {
	    Inventory inventory = optional.get();
	    if (inventory.getAmount() == 0) {
		throw new Error(productId + " Not Found");
	    }
	    inventory.setAmount(inventory.getAmount() - 1);
	    inventoryDao.save(inventory);
	    return "ok";
	} else {
	    throw new Error(productId + " Not Found");
	}
    }

    @Override
    public Inventory viewInventory(String productId) {
	Optional<Inventory> inventory = inventoryDao.findById(productId);
	if (inventory.isPresent()) {
	    return inventory.get();
	} else {
	    throw new Error(productId + " Not Found");
	}
    }

    @Override
    public List<Inventory> showInventory() {
	Iterable<Inventory> iterable = inventoryDao.findAll();
	List<Inventory> inventoryList = new ArrayList<>();
	iterable.forEach(inventoryList::add);
	return inventoryList;
    }

}
