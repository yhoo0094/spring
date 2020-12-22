package co.company.spring;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConfiguration.class})
public class EmpDaoMapperClient {

	@Autowired
	EmpMapper empDAO;

//	@Test
	public void empdaotest() {
		Emp empvo = new Emp();
//		empvo.setFirstName("pa");
//		empvo.setDepartmentId("10");
//		empvo.setSalary(10000);
		
//		List<Emp> list = empDAO.getEmpList(empvo);
//		for(Emp emp : list) {
//			System.out.println(emp.getEmployeeId() + ":"
//					+ emp.getFirstName() + ":"
//					+ emp.getDepartmentId() + ":"
//					+ emp.getJobId() + ":"
//					+ emp.getSalary());
//		}
		
////		searchVO활용하기
//		EmpSearch empSearch = new EmpSearch();
//		empSearch.setFirstName("st");
//		empSearch.setMaxSalary(20000);
//		empSearch.setMinSalary(10000);
//		List<EmpSearch> list = empDAO.getEmpList(empSearch);
//		for(Emp emp : list) {
//			System.out.println(emp.getEmployeeId() + ":"
//					+ emp.getFirstName() + ":"
//					+ emp.getDepartmentId() + ":"
//					+ emp.getJobId() + ":"
//					+ emp.getSalary());
//		}		
	}
	
//	@Test
	public void updateTest() {
		Emp empvo = new Emp();
		empvo.setEmployeeId("102");
		System.out.println(empDAO.getEmp(empvo));
		empvo.setFirstName("hong");
		empDAO.updateEmp(empvo);
		System.out.println(empDAO.getEmp(empvo));
	}
	
	//@Test
	public void insertTest() {
		Emp emp = new Emp();
		emp.setFirstName("길동");
		emp.setLastName("choi");
		emp.setJobId("IT_PROG");
		emp.setEmail("a@a.a");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		empDAO.insertEmp(emp);
		System.out.println(emp.getEmployeeId());
	}
	
	//@Test
	public void deleteTest() {
		EmpSearch empSearch = new EmpSearch();
		empSearch.setList(new String[] {"207"});
		empDAO.deleteMultiEmp(empSearch);
	}
	
	//@Test
	public void insertProcTest() {
		Emp emp = new Emp();
		emp.setLastName("choi");
		emp.setJobId("IT_PROG");
		emp.setEmail("a@a.a");
		empDAO.insertEmpProc(emp);
		System.out.println(emp.getEmployeeId()
				   + ":" + emp.getMsg());
	}
	
	//@Test
	public void countTest() {
		EmpSearch empSearch = new EmpSearch();
//		empSearch.setFirstName("st");
		empSearch.setMaxSalary(20000);
		empSearch.setMinSalary(10000);
		System.out.println(empDAO.getCount(empSearch));
		
	}
	
	@Test
	public void getStatDept() {
		List<Map<String, Object>> list =
				empDAO.getStatDept();
		System.out.println(list.get(0));
		//컬럼명이 map의 키값으로 들어감
		System.out.println(list.get(0).get("deptName"));
	}
}

