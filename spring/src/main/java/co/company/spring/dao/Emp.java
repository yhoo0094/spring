package co.company.spring.dao;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Emp {
	@JsonProperty(value = "empId")
	String employeeId;   
	String firstName;
	String lastName;
	String email;
	/* @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss") */ /* 데이터가 선택 */
	@JsonFormat(shape = Shape.STRING) /* 데이터가 필수 */
	Date hireDate;	
	String jobId;	
	String departmentId;
	@JsonIgnore Integer salary;
	@JsonIgnore String msg;
}