package com.phonepe.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8192897470482440056L;
    @Id
    private String productId;
    private int amount;

    public String getProductId() {
	return productId;
    }

    public void setProductId(String productId) {
	this.productId = productId;
    }

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
    }

}
