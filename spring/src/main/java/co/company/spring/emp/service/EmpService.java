package co.company.spring.emp.service;

import java.util.List;
import java.util.Map;

import co.company.spring.dao.Depts;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;

public interface EmpService {
	public List<Map<String, Object>> getStatDept();
	public List<Emp> getEmpList(Emp emp);
	public int getCount(EmpSearch emp);
	
	public List<Emp> getEmpList(EmpSearch emp);
	public Emp getEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int insertEmp(Emp emp);
	public int deleteEmp(Emp emp);
	public int deleteMultiEmp(EmpSearch emp);
	public void insertEmpProc(Emp emp);
	public List<Jobs> jobSelect();
	public List<Depts> deptSelect();
}
