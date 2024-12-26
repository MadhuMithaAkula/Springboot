package com.tcs.mvc.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.mvc.enity.ProductEntity;
import com.tcs.mvc.model.Product;
import com.tcs.mvc.service.ProductService;

import jakarta.validation.Valid;


@Controller
public class ProductController 
{
@Autowired
ProductService productService;

/*@GetMapping("/productform")
public String getproductform()
{
return "add-product";	
}

	@PostMapping("/saveProduct")
	public String  saveProduct(Product product)
	{
  productService.saveproductDetails(product);
		return "Success";
}*/
	@GetMapping("/getallproducts")
	public String getAllProducts(Model model)
	{
		List<ProductEntity> products=productService.getAllProducts();
		model.addAttribute("products", products);
		return "product-list";
		
	}
	@GetMapping("/getsearchbyid")
	public String getsearchform()
	{
		return "searchform";
	}
	@PostMapping("/searchbyid")
	public String searchbyid(@RequestParam Long id, Model model)
	{
		ProductEntity product= productService.searchbyid(id);
		model.addAttribute("product", product);
		return "searchform";
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable ("id")long id)
	{
		productService.deleteById(id);
		return "redirect:/getallproducts";
	}
	@GetMapping("/edit/{id}")
	public String editProductById(@PathVariable("id") Long id, Model model)
	{
		Product product= productService.editProductById(id);
		
		model.addAttribute("product", product);
		model.addAttribute("id",id);
		return "edit-product";
	}
	
	@PostMapping("/editproductsave/{id}")
    public String saveEditedProduct(@PathVariable("id") Long id, @ModelAttribute ProductEntity Product)
	{
        productService.updateProduct(id, Product);
        
        return "redirect:/getallproducts";
    }
	
	@GetMapping("/productform")
	public String getproductform(Model model)
	{
		Product product=new Product();
		
		product.setMadein("India");
		product.setQuantity(1);
		product.setDiscountrate(10);
		
	    model.addAttribute("product",product);
	    
	    return "add-product";
	}
	@PostMapping("/saveproduct")
	public String saveproduct(@Valid Product product,BindingResult bindingResult,Model model)
	{
		HashMap<String, String> validationErrors=new HashMap<String,String>();
		
		if(bindingResult.hasErrors())
		{
			for(FieldError fieldError : bindingResult.getFieldErrors())
			{ 
				validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			model.addAttribute("validationErrors",validationErrors);
			
			return "add-product";
		}
		productService.saveproductDetails(product);
		return "redirect:/getallproducts";
	}
}
