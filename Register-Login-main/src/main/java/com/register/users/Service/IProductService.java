package com.register.users.Service;

import com.register.users.Dto.ProductRegisterDto;
import com.register.users.Entity.Product;

import java.util.List;

public interface IProductService{

    Product saveProduct(ProductRegisterDto productRegisterDto);
    List<Product>productList();
}
