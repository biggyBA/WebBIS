<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
	<title>Submit fault</title>
</head>


<body>
			
	<jsp:include page="_supportMenu.jsp" />


<div id="wrapper">
    
    <div id="first">
    
    <h1>Submit fault</h1>
        
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
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    
    </div>
    
    
    <div id="second"></div>
    
    <div id="third"></div>
    
</div>


</body>
</html>





<style type="text/css">
div {
    display: block;
}
#wrapper {
    width: 100%;
    height:100%;
    
}

#first {
    float:left;
    width: 29%;
    height: 98%;
    border-style: solid;
    border-width: 1px;
    border-color: rgb(130, 130, 130);
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

tr:nth-child(even) {background-color: #f2f2f2}


</style>