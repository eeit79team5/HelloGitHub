<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- request.setCharacterEncoding("UTF-8"); --%>  <%-- �bStruts 2 ���w�i�ٲ� --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>hello.jsp</title>
<s:head theme="xhtml" /> <!--�w�]�� xhtml --> <!--theme �i�� xhtml �� simple �� css_xhtml --> 
</head>
<body>
<h3>�ڬO�i�ܼh (view) hello.jsp</h3>
<UL>

<%--         <LI>  Hello, ${empVO.ename}                �iEL���ȡj</LI> --%>
<%--         <LI>  Hello, ${sessionScope.empVO.ename}                �iEL���ȡj</LI>         --%>
<%--         <LI>  Hello, <s:property value="#session.empVO.ename" />  �iOGNL���ȡj</LI> --%>
        
        <LI>  Hello, ${empVO.ename}                �iEL���ȡj</LI>
        <LI>  Hello, ${empVO.sal}                �iEL���ȡj</LI>
        <LI>  Hello, ${empVO.hiredate}                �iEL���ȡj</LI>
        <LI>  Hello, ${empVO.hiretime}                �iEL���ȡj</LI>
        
<%--         <LI>  Hello, ${sessionScope.empVO.ename}                �iEL���ȡj</LI>  --%>
        <LI>  Hello, ${requestScope.empVO.ename}                �iEL���ȡj</LI>        
        <LI>  Hello, ${requestScope.empVO.sal}                �iEL���ȡj</LI>  
        <LI>  Hello, ${requestScope.empVO.hiredate}                �iEL���ȡj</LI>  
        <LI>  Hello, ${requestScope.empVO.hiretime}                �iEL���ȡj</LI>  
                     
<%--         <LI>  Hello, <s:property value="#session.empVO.ename" />  �iOGNL���ȡj</LI> --%>
		<LI>  Hello, <s:property value="#request.empVO.ename" />  �iOGNL���ȡj</LI>        
        <LI>  Hello, <s:property value="#request.empVO.sal" />  �iOGNL���ȡj</LI>        
        <LI>  Hello, <s:property value="#request.empVO.hiredate" />  �iOGNL���ȡj</LI>        
        <LI>  Hello, <s:property value="#request.empVO.hiretime" />  �iOGNL���ȡj</LI>        
        
 </UL>
</body>
</html>
