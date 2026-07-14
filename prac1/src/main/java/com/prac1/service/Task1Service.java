package com.prac1.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prac1.entity.CustomerEntity;
import com.prac1.entity.DepartmentEntity;
import com.prac1.entity.EmployeeEntity;
import com.prac1.entity.OrderEntity;
import com.prac1.repository.CustomerRepository;
import com.prac1.repository.DepartmentRepository;
import com.prac1.repository.EmployeeRepository;
import com.prac1.repository.OrderRepository;
import com.prac1.request.EmployeeRequest;
import com.prac1.request.OrderRequest;

@Service
public class Task1Service {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Integer saveEmployee(EmployeeRequest employeeRequest) {
		
		String empDep = employeeRequest.getDepartmentName();
		Optional<DepartmentEntity> depEnt = departmentRepository.findByDepartmentName(empDep);
		
		DepartmentEntity depEntToUse;
		
		if(depEnt.isPresent()) depEntToUse = depEnt.get();
		else {
			depEntToUse = new DepartmentEntity();
			depEntToUse.setDepartmentName(employeeRequest.getDepartmentName());
			depEntToUse.setStatus("Active");
			departmentRepository.save(depEntToUse);
		}
		
		EmployeeEntity empEnt = new EmployeeEntity();
		empEnt.setName(employeeRequest.getName());
		empEnt.setSalary(employeeRequest.getSalary());
		empEnt.setDepartment(depEntToUse);
		
	    EmployeeEntity savedEmpEnt = employeeRepository.save(empEnt);
	    return savedEmpEnt.getId();
		
		
	}
	
	@Autowired 
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Integer saveOrder(OrderRequest orderRequest) {
		
		Optional<CustomerEntity> CusEnt = customerRepository.
				findByCustomerNameAndCustomerEmail(orderRequest.getCustomerName(), orderRequest.getCustomerEmail());
		
		CustomerEntity cusEntToUse;
		if(CusEnt.isPresent()) cusEntToUse = CusEnt.get();
		else {
			cusEntToUse = new CustomerEntity();
			cusEntToUse.setCustomerName(orderRequest.getCustomerName());
			cusEntToUse.setCustomerEmail(orderRequest.getCustomerEmail());
			cusEntToUse.setOrderEntities(new ArrayList<>());
			cusEntToUse = customerRepository.save(cusEntToUse);
		}
		
		OrderEntity order = new OrderEntity();
		order.setProductName(orderRequest.getProductName());
		cusEntToUse.getOrderEntities().add(order);
		order.setCustomerEntity(cusEntToUse);
		
		
		Integer id = orderRepository.save(order).getOrderId();
		return id;
	}

}
