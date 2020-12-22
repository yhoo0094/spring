package co.company.spring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;

@Controller
public class EmpController {
	@Autowired
	EmpMapper dao;
	
	@RequestMapping(value = "/empSelect", method = RequestMethod.GET)
	public String select() {
		//조회
		return "emp/select";
	}
	
	@GetMapping("/empInsertForm")
	public String insertForm(Model model, Emp emp) {
		model.addAttribute("jobs", dao.jobSelect());
		model.addAttribute("depts", dao.deptSelect());
		return "emp/insert";
	}
	
	@PostMapping("/empInsert")
	public String insert(Emp emp, @ModelAttribute("employee") Emp emp2) {
		dao.insertEmp(emp);
		return "emp/insertOutput";
	}
	
	//@PostMapping("/empInsert")
	public String insert(HttpServletRequest request, HttpServletResponse response ,
		 @RequestParam String lastName,
		 @RequestParam(value="lastName",
				 		required = false,
				 		defaultValue = "noname") String LName,
		@RequestParam(required = false) int salary, Emp emp) throws UnsupportedEncodingException{
		//파라미터(@RequestParam String firstName 으로 처리해도 똑같다!)
			//HttpServletRequest request 이거 매개 변수로 받고!
			String firstName = request.getParameter("firstName");
			System.out.println(lastName + ":" + firstName);
			System.out.println("LName:" + LName);
			System.out.println("salary:" + salary);
			System.out.println("emp:" + emp);
		//등록처리
		//redirect(url값을 넣어줘야한다)
		return "redirect:empSelect";
	}
	
	@GetMapping("/empUpdateForm")
	public String UpdateForm(Model model, Emp emp) {
		model.addAttribute("emp", dao.getEmp(emp));
		model.addAttribute("jobs", dao.jobSelect());
		model.addAttribute("depts", dao.deptSelect());
		return "emp/insert";
	}
	
	
}
