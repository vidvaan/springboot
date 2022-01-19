package com.createiq.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.createiq.model.Employee;
import com.createiq.model.ResponseModel;
import com.createiq.service.EmployeeService;

@Controller("empController")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/addEmp")
	public String showAddEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmp";
	}
	
	@RequestMapping("/allEmp")
	public ModelAndView showAllEmp() {
		List<Employee> employees = employeeService.findAll();
		return new ModelAndView("allEmp","employees",employees);
	}
	
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public String saveEmp(@Valid  Employee employee, BindingResult result,Model model) {
		model.addAttribute("employee", employee);
		
		if(result.hasErrors()) {
			return "addEmp";
		}
		employeeService.add(employee);
		return "redirect:/allEmp";
	}
	
	
	
	
	//deleteById

	@RequestMapping("/deleteById")
	public String deleteById(@RequestParam("eid") Integer eid) {
		employeeService.deleteById(eid);
		return "redirect:/allEmp";
	}
	
	@RequestMapping("/updateEmpShow")
	public ModelAndView showUpdateEmp(@RequestParam("eid") Integer eid) {
		Employee employee = employeeService.findById(eid);
		return new ModelAndView("updateEmp","employee",employee);
	}
	
	@RequestMapping(value="/updateEmp",method=RequestMethod.POST)
	public String updateEmp(Employee employee) {
		
		System.out.println(employee);
		employeeService.update(employee);
		return "redirect:/allEmp";
	}
	
	
	@RequestMapping(value="/rest/xml/allEmp", produces= "application/xml")
	public @ResponseBody List<Employee> findAllRS(){
		return employeeService.findAll();
	}
	
	@RequestMapping(value="/rest/json/allEmp", produces= "application/json")
	public @ResponseBody List<Employee> findAllRSJson(){
		return employeeService.findAll();
	}
	
	
	
}
