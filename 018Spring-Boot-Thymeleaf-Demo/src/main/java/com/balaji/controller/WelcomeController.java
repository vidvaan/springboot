package com.balaji.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.balaji.model.Employee;

@Controller
public class WelcomeController {

	@Value("${msg}")
	private String msg;

	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("msg", msg);
		return "welcome";
	}

	public List<Employee> findAll() {
		List<Employee> employees = Stream
				.of(new Employee(1001, "Balaji", 1000.00), new Employee(1002, "Raja", 1000.00),
						new Employee(1003, "Rani", 1000.00), new Employee(1004, "Joy", 1000.00))
				.collect(Collectors.toList());

		return employees;

	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login";  
     }  

	@GetMapping("/findAllEmp")
	public String getEmps(Model model) {
		model.addAttribute("emps",  findAll() );
		return "findAll";
	}

}
