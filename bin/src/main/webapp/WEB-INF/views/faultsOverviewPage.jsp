<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Faults overview</title>
</head>


<body>
	
	<jsp:include page="_supportMenu.jsp" />


<div align="left">
            <h1>Faults overview</h1>
            
            <table>
            	
                <th>Date</th>
                <th>Time</th>
                <th>Product type</th>
                <th>Client</th>
                <th>Street</th>
                <th>Place</th>
                <th>Phone #1</th>
                <th>Phone #2</th>
                <th>Fault description</th>
                <th>Note</th>
                <th>Serviceman</th>
                <th>Type of service</th>
                 
                <c:forEach var="fault" items="${faultsToDo}" varStatus="status">
                <tr>
                    <!--<td>${status.index + 1}</td>-->
                    <!--<td>${fault.id}</td>-->
                    <td>${fault.date}</td>
                    <td>${fault.time}</td>
                    <td>${fault.ident}</td>
                    <td>${fault.client}</td>
                    <td>${fault.street}</td>
                    <td>${fault.place}</td>
                    <td>${fault.phoneOne}</td>
                    <td>${fault.phoneTwo}</td>
                    <td>${fault.faultDescription}</td>
                    <td>${fault.note}</td>
                    <td>${fault.serviceman}</td>
                    <td>${fault.typeOfService}</td>
                    <td>
                        <a href="/WebBIS/editFault?id=${fault.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/WebBIS/deleteFault?id=${fault.id}">Delete</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/WebBIS/archiveFault?id=${fault.id}">Archive</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
	

</body>
</html>



<style type="text/css">

table{
   border: 1px solid;
   border-collapse: collapse;
   width: 100%;
}

tr, th, td{
	border: 1px solid;
	border-collapse: collapse;
}

</style>