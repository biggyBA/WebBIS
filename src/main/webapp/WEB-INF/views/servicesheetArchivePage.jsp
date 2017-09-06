<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<link href="<c:url value="/resources/css/themeOne/style.css" />" rel="stylesheet">
	<title>Servicesheet archive</title>
</head>


<body>
	
	<jsp:include page="_supportMenu.jsp" />

	<div id="wrapper">
		<div id="first">

			<table>
            	<tr>
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
                <tr/> 
                
                <c:forEach var="fault" items="${faultsDone}" varStatus="status">
	                <tr>
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
	                    <td><a href="${pageContext.request.contextPath}/editFault?id=${fault.id}">Edit</a></td>
	                    <td><a href="${pageContext.request.contextPath}/deleteFault?id=${fault.id}">Delete</a></td>
	                    <td><a href="${pageContext.request.contextPath}/archiveFault?id=${fault.id}">Archive</a></td>
	                             
	                </tr>
                </c:forEach>             
            </table>
            
		</div> <!-- close first -->
		
		<div id="second"></div>

	</div> <!-- close wrapper -->

</body>

<style type="text/css">
div {
    display: block;
}
#wrapper {
    width: 100%;
    height:100%;
}

#first {
    width: 100%;
    height: 50%;
    overflow-y: scroll;
    padding-top: 15px;
}

#second {
    width: 100%;
    height: 50%;
    border: 1px solid white;
}

table {
    color: white;
    border: 1px solid #3c82f2;
    border-collapse: collapse;
    width: 100%;
    font-family: Arial;
}

th {
    color: white;
    border: 1px solid #3c82f2;
    padding: 5px;
}

tr {
    color: white;
    border: 1px solid #3c82f2;
    
}

td {
    color: white;
    border: 1px solid #3c82f2;
    padding: 5px;
}

</style>
</html>