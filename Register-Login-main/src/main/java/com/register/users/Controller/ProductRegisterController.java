package com.register.users.Controller;

import com.register.users.Dto.ProductRegisterDto;
import com.register.users.Entity.Product;
import com.register.users.Service.IProductService;
import com.register.users.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registerproduct")
public class ProductRegisterController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    IProductService product_Service;

    @ModelAttribute("product")
    public ProductRegisterDto returnNewProductDto(){
        return new ProductRegisterDto();
    }

    @GetMapping
    public String showFormRegisterProduct() {
        return "registerproduct";
    }

    @PostMapping
    public String registerProduct(@ModelAttribute("product") ProductRegisterDto registerDto) {
        productService.saveProduct(registerDto);
        return "redirect:/registerproduct?success";
    }
}
