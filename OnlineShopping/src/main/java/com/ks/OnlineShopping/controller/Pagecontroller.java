package com.ks.OnlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ks.ShoppingBackEnd.dao.CategoryDAO;
import com.ks.ShoppingBackEnd.dto.Category;


@Controller
public class Pagecontroller {
	@Autowired
	private CategoryDAO categoryDAO;
	
		
	
	
	@RequestMapping(value= {"/", "/home", "/page"})
    public ModelAndView indext() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		// PASSING THE LIST CATEGORY
				mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome",true);
        return mv;
    }
	
	
	@RequestMapping(value= {"/about"})
    public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
        return mv;
    }
	
	@RequestMapping(value= {"/contact"})
    public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
        return mv;
    }
	/*
	 * methods to load all the products and based on category
	 * 
	 * */
	@RequestMapping(value= "/show/all/products")
    public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		
		// PASSING THE LIST CATEGORY
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
        return mv;
	}

	@RequestMapping(value= "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		
		//categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title",category.getName());
		
		// PASSING THE LIST CATEGORY
		mv.addObject("categories", categoryDAO.list());
		
		//passing the single category
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
        return mv;

}
	 }








