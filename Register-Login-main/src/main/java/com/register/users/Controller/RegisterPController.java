package com.register.users.Controller;

import com.register.users.Entity.Product;
import com.register.users.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class RegisterPController {
    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String loginProduct(){
        return"index";
    }

    @GetMapping("/")
    public String showProductHomepage(Model model1){
        model1.addAttribute("products",productService.productList());
        return "index";
    }
}
