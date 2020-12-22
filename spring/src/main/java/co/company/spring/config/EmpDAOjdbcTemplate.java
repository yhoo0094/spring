package co.company.spring.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import co.company.spring.dao.Emp;



@Component
public class EmpDAOjdbcTemplate {
	final String SELECT = "select * from employees";
	final String INSERT = "INSERT INTO EMPLOYEES("
			+ "EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID) "
			+ "VALUES(?,?,?,SYSDATE,'IT_PROG')";				 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getListMap(){
		return jdbcTemplate.queryForList(SELECT);
	}
	
	public void insert(Emp emp) {
		Object[] param = new Object[]{
			emp.getEmployeeId(), 
			emp.getLastName(), 
			emp.getEmail()
		};
		jdbcTemplate.update(INSERT, param);
		//jdbcTemplate.update(INSERT, emp.getEmployeeId(), emp.getLastName(), emp.getEmail());
	}
	
	public List<Emp> getList(){
		return jdbcTemplate.query(SELECT, new RowMapper<Emp>(){
			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmployeeId(rs.getString("employee_id"));
				return emp;
			}});
	}
	
}
