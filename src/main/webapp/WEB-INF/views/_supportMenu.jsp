<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>

<!--
<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

	<a href="${pageContext.request.contextPath}/">Home</a> | &nbsp; 

	<a href="${pageContext.request.contextPath}/faultsOverview">Faults overview</a> | &nbsp; 
		
	<a href="${pageContext.request.contextPath}/submitFault">Submit fault</a> | &nbsp; 
	
	<a href="${pageContext.request.contextPath}/servicesheetArchive">Servicesheet archive</a> | &nbsp;

</div>
-->



<div class="container">
  
  <a href="${pageContext.request.contextPath}/">Home</a>
  
  <a href="${pageContext.request.contextPath}/faultsOverview">Faults overview</a>
  
  <a href="${pageContext.request.contextPath}/submitFault">Submit fault</a>
  
  <div class="dropdown">
    <button class="dropbtn">Servicesheet archive</button>
    
    <div class="dropdown-content">
      <a href="${pageContext.request.contextPath}/servicesheetArchive">Archived faults</a>
      <a href="${pageContext.request.contextPath}/enterServicesheet">Enter servicesheet</a>
      <a href="#">Archive 3</a>
    </div>
    
  </div> 
    
</div>



<style>
.container {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
    border-bottom: solid 1px #3c82f2;
}

.container a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.container a:hover, .dropdown:hover .dropbtn {
    background-color: #3c82f2;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>