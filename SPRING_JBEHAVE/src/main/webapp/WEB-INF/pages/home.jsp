<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Home With Jbehave</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	<body>

<div class="w3-container">
		<h1>Home Page</h1>
		<table  class="w3-table-all w3-hoverable">
			 <thead>
        	<tr class="w3-light-grey">
            <td>User Id</td>
            <td>Account Number</td>
            <td>Account Type</td>
            <td>Bank</td>
            <td>Status</td>
            <td>Account Holder Name</td>
            <td>Branch</td>
        </tr>
      </thead>
        
              <tbody>
        <c:forEach  items="${list}" var="tester">
            <tr class="w3-light-grey">
                <td>${tester.userId}</td>
                <td>${tester.accountNumber}</td>
                <td>${tester.accountType}</td>
                <td>${tester.bank}</td>
                <td>${tester.status}</td>
                <td>${tester.accountHolderName}</td>
                <td>${tester.branch}</td>
            </tr>
        </c:forEach>
      </tbody>
</table>
</div>
	</body>
</html>