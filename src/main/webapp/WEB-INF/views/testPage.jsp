<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<title>Test</title>
</head>

<body>
    
    <div id="wrapper">
    
    	<div>
    	
    		<form:form action="testPost" method="post" modelAttribute="fault">
    		
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
            	
            	<div>
	            	<img src="<c:url value="/resources/images/iconProductType.png"/>"/>	
	            	
	            	<form:select path="ident">
						<form:option value="" label="Select product type"/>
					    <form:options  items="${productTypeList}"/>
					</form:select>	
            	</div>	
            		
            	<div>
            		<img src="<c:url value="/resources/images/iconBarcode.png"/>"/>
            	
		    		<form:input path="serialNumber" type="text" placeholder="Serial number"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconClient.png"/>"/>
            	
		    		<form:input path="client" type="text" placeholder="Client"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconStreet.png"/>"/>
            	
		    		<form:input path="street" type="text" placeholder="Street"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconPlace.png"/>"/>
            	
		    		<form:input path="place" type="text" placeholder="Place"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconPhone.png"/>"/>
            	
		    		<form:input path="phoneOne" type="text" placeholder="Phone #1"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconPhone.png"/>"/>
            	
		    		<form:input path="phoneTwo" type="text" placeholder="Phone #2"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconDescription.png"/>"/>
            	
		    		<form:textarea path="faultDescription" cols="30" rows="5" placeholder="Fault description"/>
			    </div>
			    
			    <div>
            		<img src="<c:url value="/resources/images/iconNote.png"/>"/>
            	
		    		<form:textarea path="note" cols="30" rows="5" placeholder="Note"/>
			    </div>
			    
			    <div>
	            	<img src="<c:url value="/resources/images/iconClient.png"/>"/>	
	            	
	            	<form:select path="serviceman">
						<form:option value="" label="Select serviceman"/>
					    <form:options  items="${servicemanList}"/>
					</form:select>	
            	</div>
            	
            	<div>
	            	<img src="<c:url value="/resources/images/iconClient.png"/>"/>	
	            	
	            	<form:select path="orderBy">
						<form:option value="" label="Select"/>
					    <form:options  items="${usersList}"/>
					</form:select>	
            	</div>
            	
            	<div>
	            	<img src="<c:url value="/resources/images/iconClient.png"/>"/>	
	            	
	            	<form:select path="typeOfService">
						<form:option value="" label="Select type of service"/>
					    <form:options  items="${typeOfServiceList}"/>
					</form:select>	
            	</div>
            	
            	<div id="submitDiv">
	            	<input type="submit" value="Submit fault" id="submitBtn"/>	
            	</div>
		    
		    </form:form>
		    	
    	</div>
    
    
    </div> <!-- close wrapper -->
    
    
    
</body>




</html>