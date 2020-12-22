package co.company.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOMybatis {
	@Autowired SqlSession sqlSession;
	
	public List<Emp> getEmpList() {
		return sqlSession.selectList("EmpDAO.getEmpList");
	}
}
