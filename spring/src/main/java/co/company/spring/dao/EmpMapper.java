package co.company.spring.dao;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

	public List<Emp> getEmpList(Emp emp);
	public List<EmpSearch> getEmpList(EmpSearch emp);
	public Emp getEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int insertEmp(Emp emp);
	public int deleteEmp(Emp emp);
	public int deleteMultiEmp(EmpSearch emp);
	public void insertEmpProc(Emp emp);
	public int getCount(EmpSearch emp);
	public List<Map<String, Object>> getStatDept();
	public List<Jobs> jobSelect();
	public List<Depts> deptSelect();
}
