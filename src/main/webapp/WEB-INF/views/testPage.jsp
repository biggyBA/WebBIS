<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<title>Test</title>
</head>

<body>
    
    <table border="1" align="center" style="witdth:50%">
    
    
    	<thead>
    		<tr>
    			<th>One</th>
    			<th>Two</th>
    		</tr>
    		
    	</thead>	
    
    
    	<tbody>
    	
    		<c:forEach var="faults" items="${faults}">
    			<tr>
    				<td>${faults.id}</td>
    				<td>${faults.client}</td>
    			</tr>
    		
    		
    		</c:forEach>
    	
    	
    	
    	</tbody>
    
    </table>
    
    
    
</body>




</html>