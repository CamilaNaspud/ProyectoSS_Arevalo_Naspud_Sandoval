package com.register.users.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductRegisterDto {

    private Long product_id;
    private String product_name;
    private float product_basePrice;
    private float product_finalPrice;
    private String product_description;

    public ProductRegisterDto() {
    }
    public ProductRegisterDto(Long product_id, String product_name, float product_basePrice, float product_finalPrice, String product_description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_basePrice = product_basePrice;
        this.product_finalPrice = product_finalPrice;
        this.product_description = product_description;
    }

    public ProductRegisterDto(Long product_id, String product_name, float product_basePrice, String product_description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_basePrice = product_basePrice;
        this.product_description = product_description;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_basePrice() {
        return product_basePrice;
    }

    public void setProduct_basePrice(float product_basePrice) {
        this.product_basePrice = product_basePrice;
    }

    public float getProduct_finalPrice() {
        return product_finalPrice;
    }

    public void setProduct_finalPrice(float product_finalPrice) {
        this.product_finalPrice = product_finalPrice;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
}
