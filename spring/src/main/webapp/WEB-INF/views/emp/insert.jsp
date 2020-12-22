<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.jsp</title>
<style type="text/css">
.springformCheck{
	background-color: red;
	display: block;
}
</style>
</head>
<body>
<h1>사원등록/수정</h1>
<form:form action="empInsert" method="post" modelAttribute="emp">
	<c:if test="${not empty emp.employeeId }">
		<form:input path="employeeId" readonly="true"/><br>
	</c:if>
	<form:input path="firstName" placeholder="firstName"/><br>
	<form:input path="lastName" placeholder="lastName"/><br>
	<%-- <form:input path="LastName" placeholder="LastName"/><br> --%>
	<form:input path="salary" placeholder="salary"/><br>
	<form:input path="email" placeholder="email"/><br>
	<form:select path="jobId" cssClass="springformCheck">
		<form:option value="">job 선택</form:option>
		<form:options items="${jobs}" itemLabel="jobTitle" itemValue="jobId" />
	</form:select><br>
	<%-- <form:select path="jobId" items="${jobs}" itemLabel="jobTitle" itemValue="jobId"/><br> --%>
	<form:radiobuttons path="departmentId" items="${depts}" itemLabel="departmentName" itemValue="departmentId" cssClass="springformCheck"/><br>
	<%-- <form:checkboxes path="departmentId" items="${depts}" itemLabel="departmentName" itemValue="departmentId" cssClass="springformCheck"/><br> --%>
	<%-- <form:select path="departmentId" items="${depts}" itemLabel="departmentName" itemValue="departmentId"/><br> --%>
	<form:input type="date" path="hireDate" placeholder="hireDate"/><br>
	<button>등록</button>
</form:form>
</body>
</html>