<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/css/themeOne/style.css" />" rel="stylesheet">
	<title>Faults overview</title>
</head>


<body>
	
	<jsp:include page="_supportMenu.jsp" />


<div id="tableHolder">
            
            
            <table id="table-fill">
            	
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
                        <a href="${pageContext.request.contextPath}/editFault?id=${fault.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/deleteFault?id=${fault.id}">Delete</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/archiveFault?id=${fault.id}">Archive</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
	

</body>
</html>



<style type="text/css">

#tableHolder {
    padding-top: 30px; 
}

#table-fill {
  background: white;
  border-radius:3px;
  border-collapse: collapse;
  height: 320px;
  margin: auto;
  padding:5px;
  width: 100%;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
  animation: float 5s infinite;
}

th {
  color:#D5DDE5;;
  background:#1b1e24;
  border-bottom:4px solid #9ea7af;
  border-right: 1px solid #343a45;
  font-size:18px;
  font-weight: 100;
  text-align:left;
  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
  vertical-align:middle;
  font-family: Arial;
  word-wrap: break-word;
  max-width: 150px;
}

th:first-child {
  border-top-left-radius:3px;
}
 
th:last-child {
  border-top-right-radius:3px;
  border-right:none;
}

tr {
  border-top: 1px solid #C1C3D1;
  border-bottom-: 1px solid #C1C3D1;
  color:#666B85;
  font-size:16px;
  font-weight:normal;
  text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
  word-wrap: break-word;
  max-width: 150px;
}
 
tr:hover td {
  background:#4E5066;
  color:#FFFFFF;
  border-top: 1px solid #22262e;
  border-bottom: 1px solid #22262e;
}
 
tr:first-child {
  border-top:none;
}

tr:last-child {
  border-bottom:none;
}
 
tr:nth-child(odd) td {
  background:#EBEBEB;
}
 
tr:nth-child(odd):hover td {
  background:#4E5066;
}

tr:last-child td:first-child {
  border-bottom-left-radius:3px;
}
 
tr:last-child td:last-child {
  border-bottom-right-radius:3px;
}
 
td {
  background:#FFFFFF;
  padding:5px;
  text-align:left;
  vertical-align:middle;
  font-size:18px;
  //text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
  border-right: 1px solid #C1C3D1;
  word-wrap: break-word;
  max-width: 200px;
}

td:last-child {
  border-right: 0px;
}

th.text-left {
  text-align: left;
}

th.text-center {
  text-align: center;
}

th.text-right {
  text-align: right;
}

td.text-left {
  text-align: left;
}

td.text-center {
  text-align: center;
}

td.text-right {
  text-align: right;
}


</style>