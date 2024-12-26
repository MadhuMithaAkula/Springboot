package com.tcs.mvc.service;

import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.mvc.enity.ProductEntity;
import com.tcs.mvc.model.Product;
import com.tcs.mvc.repository.ProductRepository;
@Service
public class ProductService
{
   @Autowired
   ProductRepository productRepository;
   public void  saveproductDetails(Product product)
   {
	   double stockvalue;
	   stockvalue=product.getPrice()*product.getQuantity();
	   
	   double discountprice;
	   discountprice=product.getPrice()*product.getDiscountrate();
	   
	   double taxprice;
        taxprice=product.getPrice()*0.18;
        
 	   double offerprice;
       offerprice=product.getPrice()-discountprice;
        
	   double finalprice;
        finalprice= offerprice+taxprice;
        
        ProductEntity productEntity=new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setBrand(product.getBrand());
        productEntity.setMadein(product.getMadein());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setDiscountrate(product.getDiscountrate());
        productEntity.setDiscountprice(discountprice);
        productEntity.setStockvalue(stockvalue);
        productEntity.setTaxrate(taxprice);
        productEntity.setOfferprice(offerprice); 
        productEntity.setFinalprice(finalprice);
	 
        productRepository.save(productEntity);
   }
   public List<ProductEntity>getAllProducts()
   {
	   List<ProductEntity>products=productRepository.findAll();
	   return products;
   }
   
   public ProductEntity searchbyid(long id)
   {
	   Optional<ProductEntity>optionaldata = productRepository.findById(id);
	   if(optionaldata.isPresent())
	   {
		   ProductEntity product = optionaldata.get();
		   return product;
	   }
	   else {
		return null;
	}
		
	}
public void deleteById(long id) 
{
	productRepository.deleteById(id);
}

public Product editProductById(Long id ) 
{
	
Optional<ProductEntity> optionalProduct = productRepository.findById(id);
    
    if (optionalProduct.isPresent())
    {
        ProductEntity productEntity = optionalProduct.get();
        
        
        Product productModel = new Product();
        
        productModel.setName(productEntity.getName());
        productModel.setBrand(productEntity.getBrand());
        productModel.setMadein(productEntity.getMadein());
        productModel.setPrice(productEntity.getPrice());
        productModel.setQuantity(productEntity.getQuantity());
        productModel.setDiscountrate(productEntity.getDiscountrate());
        
        return productModel;
        
    } 
    else
    {
        
        return null; 
    }
	
	
}
public void updateProduct(Long id, ProductEntity product) {
	Optional<ProductEntity> optionalData=productRepository.findById(product.getId());
	if(optionalData.isPresent())
	{
		ProductEntity productEntity=optionalData.get();
		double stockvalue;
		   stockvalue=product.getPrice()*product.getQuantity();
		   
		   double discountprice;
		   discountprice=product.getPrice()*product.getDiscountrate();
		   
		   double taxprice;
	        taxprice=product.getPrice()*0.18;
	        
	 	   double offerprice;
	       offerprice=product.getPrice()-discountprice;
	        
		   double finalprice;
	        finalprice= offerprice+taxprice;
	        
	        productEntity.setName(product.getName());
	        productEntity.setBrand(product.getBrand());
	        productEntity.setMadein(product.getMadein());
	        productEntity.setPrice(product.getPrice());
	        productEntity.setQuantity(product.getQuantity());
	        productEntity.setDiscountrate(product.getDiscountrate());
	        productEntity.setDiscountprice(discountprice);
	        productEntity.setStockvalue(stockvalue);
	        productEntity.setTaxrate(taxprice);
	        productEntity.setOfferprice(offerprice); 
	        productEntity.setFinalprice(finalprice);
		 
	        productRepository.save(productEntity);
	}
}
}

	   
  

