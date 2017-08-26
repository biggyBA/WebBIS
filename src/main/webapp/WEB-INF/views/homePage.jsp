<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<title>Home</title>
</head>


<body>
	
	<jsp:include page="_supportMenu.jsp" />


<div id="wrapper">
    
    <div id="first">
    
    </div>
    
    <div id="second">
    <jsp:include page="faultsOverviewPage.jsp"/>
    </div>
    
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
</style>