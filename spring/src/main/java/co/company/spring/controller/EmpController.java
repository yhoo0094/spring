package co.company.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Depts;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.emp.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping(value = "/empSelect", method = RequestMethod.GET)
	public ModelAndView select(EmpSearch emp) {
		ModelAndView mav = new ModelAndView();
		//조회
		mav.addObject("list", service.getEmpList(emp));
		mav.setViewName("emp/select");
		return mav;
	}
	
	@GetMapping("/empInsertForm")
	public String insertForm(Model model, Emp emp) {
//		model.addAttribute("jobs", service.jobSelect());
//		model.addAttribute("depts", service.deptSelect());
		return "emp/insert";
	}
	
	@PostMapping("/empInsert")
	public String insert(Emp emp, Errors errors) {
		new EmpValidator().validate(emp, errors);
		if(errors.hasErrors()) {
			return "emp/insert";
		}
		if(emp.getEmployeeId() == null) {
			service.insertEmp(emp);
		} else {
			service.updateEmp(emp);
		}
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
//		model.addAttribute("emp", service.getEmp(emp));
//		model.addAttribute("jobs", service.jobSelect());
//		model.addAttribute("depts", service.deptSelect());
		return "emp/insert";
	}
	
	@RequestMapping("/ajax/jobSelect")
	@ResponseBody
	public List<Jobs> jobselect(){
		return service.jobSelect();
	}
	
	@ModelAttribute("jobs")
	public List<Jobs> jobs(){
		return service.jobSelect();
	}
	
	@ModelAttribute("depts")
	public List<Depts> depts(){
		return service.deptSelect();
	}
}
