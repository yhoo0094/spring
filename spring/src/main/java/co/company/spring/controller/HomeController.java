package co.company.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@Controller
public class HomeController {
	
	@Autowired EmpMapper EmpMapper;
	
	@RequestMapping("/empList")
	public String empList(Model model, EmpSearch emp) {
		model.addAttribute("list", EmpMapper.getEmpList(emp));
		return "emp/empList";
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/adminmain")
	public String adminmain() {
		return "admin/main";
	}
	
	
}
