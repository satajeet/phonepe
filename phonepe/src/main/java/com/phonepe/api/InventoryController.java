package com.phonepe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonepe.entity.Inventory;
import com.phonepe.service.InventoryService;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/showInventory", produces = { "application/json" })
    public List<Inventory> showInventory() {
	return inventoryService.showInventory();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addInventory", produces = {
	    "application/json" }, consumes = { "application/json" })
    public String addInventory(@RequestBody Inventory inventory) {
	return inventoryService.addInventory(inventory);
    }

    @RequestMapping(value = "/viewInventory/{productId}", produces = { "application/json" })
    public Inventory viewInventory(@PathVariable("productId") String productId) {
	return inventoryService.viewInventory(productId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/removeInventory/{productId}")
    public String removeInventory(@PathVariable("productId") String productId) {
	return inventoryService.removeInventory(productId);
    }

}
