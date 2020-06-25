package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping("/")
	public String openIndexPage() {
		return "index.jsp";
	}

	@RequestMapping("/addProductForm")
	public String openAddProductForm() {
		return "addProductForm.jsp";
	}

	@RequestMapping("/addProduct")
	public ModelAndView addProduct(@RequestParam("productId") int productId,
			@RequestParam("productName") String productName, @RequestParam("price") int price) {

		System.out.println("productId:" + productId);
		System.out.println("productName:" + productName);
		System.out.println("price:" + price);
		Product product = new Product(productId, productName, price);
		productRepository.save(product);

//		ModelAndView modelAndView = new ModelAndView("result.jsp");
//		
//		modelAndView.addObject("productId", productId);
//		modelAndView.addObject("productName", productName);
//		modelAndView.addObject("price", price);
//
//		return modelAndView;

		ModelAndView modelAndView = new ModelAndView("viewAllProducts.jsp");

		List<Product> allProductsList = productRepository.findAll();

		modelAndView.addObject("allProductsList", allProductsList);

		return modelAndView;

	}

	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() {

		ModelAndView modelAndView = new ModelAndView("viewAllProducts.jsp");

//		Product product1 = new Product(1001, "Water Bottle", 1200);
//		Product product2 = new Product(1002, "Chair", 2500);
//		Product product3 = new Product(1003, "Sofa", 20000);

//		List<Product> allProductsList = new ArrayList<Product>();
//		allProductsList.add(product1);
//		allProductsList.add(product2);
//		allProductsList.add(product3);

		List<Product> allProductsList = productRepository.findAll();

		modelAndView.addObject("allProductsList", allProductsList);

		return modelAndView;
	}

	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("productId") int productId) {

		productRepository.deleteById(productId);

		ModelAndView modelAndView = new ModelAndView("viewAllProducts.jsp");

		List<Product> allProductsList = productRepository.findAll();

		modelAndView.addObject("allProductsList", allProductsList);

		return modelAndView;
	}

	@RequestMapping("/updateProductForm")
	public ModelAndView openUpdateProduct(@RequestParam("productId") int productId) {

//		productRepository.(productId);

		ModelAndView modelAndView = new ModelAndView("updateProductForm.jsp");
//		Product product = productRepository.findById(productId).orElse(new Product());
		Product product = productRepository.getOne(productId);
		modelAndView.addObject("product", product);

		System.out.println("productId:" + product.getProductId());
		System.out.println("productName:" + product.getProductName());
		System.out.println("price:" + product.getPrice());

//		productRepository.save(product);

		return modelAndView;
	}

	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam("productId") int productId,
			@RequestParam("productName") String productName, @RequestParam("price") int price) {

		System.out.println("productId:" + productId);
		System.out.println("productName:" + productName);
		System.out.println("price:" + price);
		
		Product product = new Product(productId, productName, price);
		productRepository.save(product);

		ModelAndView modelAndView = new ModelAndView("viewAllProducts.jsp");

		List<Product> allProductsList = productRepository.findAll();

		modelAndView.addObject("allProductsList", allProductsList);

		return modelAndView;

	}

}
