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






</div>



<div id="second">

<h1>Done faults without servicesheet</h1>

<table>
            	
                <th>Date</th>
                <th>Time</th>
                <th>Client</th>
                <th>Street</th>
                <th>Place</th>
                 
                <c:forEach var="fault" items="${faultsDone}" varStatus="status">
                <tr>
                    <!--<td>${status.index + 1}</td>-->
                    <!--<td>${fault.id}</td>-->
                    <td>${fault.date}</td>
                    <td>${fault.time}</td>
                    <td>${fault.client}</td>
                    <td>${fault.street}</td>
                    <td>${fault.place}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/editFault?id=${fault.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/deleteFault?id=${fault.id}">Delete</a>
                        
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>


</div>




</div>

	

</body>

<style type="text/css">

#wrapper {
    width: 100%;
    height:100%;
    display: inline-block;
}

#first {
    width: 49%;
    height: 100%;
    border: 1px solid white;
    float: left;
}

#second {
    width: 50%;
    height: 100%;
    float: right;
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

h1 {
    color: white;
}

</style>
</html>