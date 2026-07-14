package com.prac1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prac1.entity.SupportTicket;
import com.prac1.request.EmployeeRequest;
import com.prac1.request.ProductRequest;
import com.prac1.service.Task1Service;

@Controller
public class Task1Controller {
	
	@Autowired
	Task1Service task1Service;
	
	@GetMapping("/search")
	public String seachMethod(@RequestParam("keyword") String keyword, Model model) {
		if(keyword.equals("java")) model.addAttribute("searchMessage","Found 5 java books");
		else model.addAttribute("searchMessage","No results found");
		return "default";
	}
	
	@GetMapping("/api/employee/{empId}")
	@ResponseBody
	public String method2(@PathVariable("empId") String empId) {
		return "fetching details for employee number" + empId;
	}
	
	@PostMapping("/submitTicket")
	@ResponseBody
	public String method3(@RequestBody SupportTicket supportTicket) {
		System.out.println("object is " + supportTicket);
		return "Ticket recieved " + supportTicket.getTitleString() + " " +
				supportTicket.getDescription() + " " + supportTicket.getPriority();
	}
	
	@GetMapping("/api/products/search")
	@ResponseBody
	public String method4(@RequestParam("keyword") String keyword) {
		return "API Search Results for :"+ keyword;
	}
	
	@GetMapping("/product/edit/{id}")
	public String method5(@PathVariable("id") String id, Model model) {
		ProductRequest req = new ProductRequest(Integer.parseInt(id),"Gaming Mouse",(float) 50);
		model.addAttribute("obj", req);
		return "editProduct";
	}
	
	@PostMapping("/product/save")
	@ResponseBody
	public String method6(@ModelAttribute ProductRequest productRequest) {
		return "successfully updated "+ productRequest.getName() + "to price "
				+ productRequest.getPrice();
	}
	
	@PostMapping("/AddEmployee")
	@ResponseBody
	public String addEmployee(@ModelAttribute EmployeeRequest employeeRequest) {
		Integer id = task1Service.saveEmployee(employeeRequest);
		return "Employee saved to DB with id = "+ id;
	}
	
	
}
