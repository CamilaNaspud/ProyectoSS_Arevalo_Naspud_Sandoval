package com.register.users.Service;

import com.register.users.Dto.ProductRegisterDto;
import com.register.users.Dto.UserRegisterDto;
import com.register.users.Entity.Product;
import com.register.users.Entity.Rol;
import com.register.users.Entity.User;
import com.register.users.Repository.IProductRepository;
import com.register.users.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product saveProduct(ProductRegisterDto registerDto){
        Product product = new Product(registerDto.getProduct_name(), registerDto.getProduct_basePrice(), registerDto.getProduct_finalPrice(), registerDto.getProduct_description());
        return productRepository.save(product);
    }
    @Override
    public List<Product> productList() {
        return productRepository.findAll();
    }
}
