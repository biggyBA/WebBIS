<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
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
                 
                <c:forEach var="fault" items="${listFault}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${fault.ident}</td>
                    <td>
                        <a href="/editContact?id=${contact.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteContact?id=${contact.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
	

</body>
</html>



<style type="text/css">

table, tr, th{
   border: 1px solid green;
}

</style>