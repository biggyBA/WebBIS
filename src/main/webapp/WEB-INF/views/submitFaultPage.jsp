<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<link href="<c:url value="/resources/css/themeOne/style.css" />" rel="stylesheet">
	<title>Submit fault</title>
</head>


<body>
			
	<jsp:include page="_supportMenu.jsp" />

	<div id="wrapper">
    	<div id="first">
    
        	<form:form action="saveFault" method="post" modelAttribute="fault">
        
		        <!-- Today date -->
		        <form:input path="date" type="hidden" id="dateLabel"/>
		        		<script type="text/javascript">
		        			var todayDate = new Date();
		        			var formatTodayDate = todayDate.toISOString().slice(0,10).replace(/-/g,"");
							var labelDate = document.getElementById("dateLabel");
							labelDate.value = formatTodayDate;	
						</script>
							
				<!-- Time now -->
		        <form:input path="time" type="hidden" id="timeLabel"/>
		        		<script type="text/javascript">
		        			var timeNow = new Date();
		        			var formatTimeNow = timeNow.getHours() + ':' + timeNow.getMinutes() + ':' + timeNow.getSeconds();
							var labelTime = document.getElementById("timeLabel");
							labelTime.value = formatTimeNow;	
						</script>
		        
		        <!-- Status -->
		        <form:input path="status" type="hidden" value="UrgentToDo"/>
        
		        <table>
		   
		            <tr>
		                <td>Product type:</td>
		                <td>
							<form:select path="ident">
								<form:option value="" label="Select"/>
				            	<form:options  items="${productTypeList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            <tr>
		                <td>Serial number:</td>
		                <td><form:input path="serialNumber" /></td>
		            </tr>
		            
		            <tr>
		                <td>Client:</td>
		                <td><form:input path="client" /></td>
		            </tr>
		            
		            <tr>
		                <td>Street:</td>
		                <td><form:input path="street" /></td>
		            </tr>
		            
		            <tr>
		                <td>Place:</td>
		                <td><form:input path="place" /></td>
		            </tr>
		            
		            <tr>
		                <td>Phone #1:</td>
		                <td><form:input path="phoneOne" /></td>
		            </tr>
	
		            <tr>
		                <td>Phone #2:</td>
		                <td><form:input path="phoneTwo"/></td>
		            </tr>
		            
		            <tr>
		                <td>Fault description:</td>
		                <td><form:textarea path="faultDescription" cols="30" rows="5" /></td>
		            </tr>
		            
		            <tr>
		                <td>Note:</td>
		                <td><form:textarea path="note" cols="30" rows="5" /></td>
		            </tr>
		            
		            <tr>
		            	<td>Serviceman:</td>
		            	<td>
		            		<form:select path="serviceman">
		            			<form:option value="" label="Select"/>
				            	<form:options  items="${servicemanList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            <tr>
		            	<td>Fault submitted by:</td>
		            	<td>
		            		<form:select path="orderBy">
		            			<form:option value="" label="Select"/>
				            	<form:options  items="${usersList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            <tr>
		            	<td>Type of service:</td>
		            	<td>
		            		<form:select path="typeOfService">
		            			<form:option value="" label="Select"/>
				            	<form:options  items="${typeOfServiceList}"/>
							</form:select>
						</td>
		            </tr>
		            
		            <tr>
		                <td colspan="2" align="center"><input type="submit" value="Submit servicesheet"></td>
		            </tr>
		            
		        </table>
		        
        	</form:form>
    
    	</div> <!-- first -->
	</div> <!-- close wrapper -->


</body>

<style type="text/css">
div {
    display: block;
    
}

#wrapper {
    width: 100%;
    height:100%;
  	left: 50%;
   	position: absolute;
   	margin: 0 0 0 -350px;
}

#first {
    width: 650px;
    height: 100%;
    padding-top: 30px;  
}

#second {
    float:left;
    width: 70%;
    height: 49%;
    border-style: solid;
    border-width: 1px;
    border-color: rgb(130, 130, 130);
}

#third {
    float:left;
    width: 70%;
    height: 49%;
    border-style: solid;
    border-width: 1px;
    border-color: rgb(130, 130, 130);
}

table {
    border: 1px solid;
    border-color: #3c82f2;
    border-collapse: collapse; 
}

td {
    border: 1px solid;
    border-color: #3c82f2;
    border-collapse: collapse;
    color: white;
    padding: 15px;
    font-family: Arial;
}

input {
    width: 400px;
}

textarea {
    width: 400px;
}

select {
    width: 400px;
}

</style>

</html>

