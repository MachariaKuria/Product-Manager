package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "Index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	/*
	 * @RequestMapping(value= "/save", method = RequestMethod.POST) public String
	 * saveProduct(@ModelAttribute("product") Product product) {
	 * 
	 * service.save(product);
	 * 
	 * return "redirect:/"; }
	 */
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable("id") Long id, Model model ) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
		
	}
	
	@RequestMapping("/contact/")
	public String showContactPage(Model model) {

		
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
			
		return "contact";
	}
	@RequestMapping("/news/")
	public String showNewsPage(Model model) {

		
		Contact news = new Contact();
		model.addAttribute("news", news);
			
		return "news";
	}
	@RequestMapping("/about/")
	public String showAboutPage(Model model) {

		
		Contact about = new Contact();
		model.addAttribute("about", about);
			
		return "about";
	}

}
