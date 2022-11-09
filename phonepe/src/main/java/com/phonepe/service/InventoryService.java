package com.phonepe.service;

import java.util.List;

import com.phonepe.entity.Inventory;

public interface InventoryService {

    public String addInventory(Inventory inventory);

    public String removeInventory(String productId);

    public Inventory viewInventory(String productId);

    public List<Inventory> showInventory();
}
