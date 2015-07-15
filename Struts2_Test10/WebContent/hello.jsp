<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- request.setCharacterEncoding("UTF-8"); --%>  <%-- 在Struts 2 中已可省略 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>hello.jsp</title>
<s:head theme="xhtml" /> <!--預設為 xhtml --> <!--theme 可為 xhtml 或 simple 或 css_xhtml --> 
</head>
<body>
<h3>我是展示層 (view) hello.jsp</h3>
<UL>

<%--         <LI>  Hello, ${empVO.ename}                【EL取值】</LI> --%>
<%--         <LI>  Hello, ${sessionScope.empVO.ename}                【EL取值】</LI>         --%>
<%--         <LI>  Hello, <s:property value="#session.empVO.ename" />  【OGNL取值】</LI> --%>
        
        <LI>  Hello, ${empVO.ename}                【EL取值】</LI>
        <LI>  Hello, ${empVO.sal}                【EL取值】</LI>
        <LI>  Hello, ${empVO.hiredate}                【EL取值】</LI>
        <LI>  Hello, ${empVO.hiretime}                【EL取值】</LI>
        
<%--         <LI>  Hello, ${sessionScope.empVO.ename}                【EL取值】</LI>  --%>
        <LI>  Hello, ${requestScope.empVO.ename}                【EL取值】</LI>        
        <LI>  Hello, ${requestScope.empVO.sal}                【EL取值】</LI>  
        <LI>  Hello, ${requestScope.empVO.hiredate}                【EL取值】</LI>  
        <LI>  Hello, ${requestScope.empVO.hiretime}                【EL取值】</LI>  
                     
<%--         <LI>  Hello, <s:property value="#session.empVO.ename" />  【OGNL取值】</LI> --%>
		<LI>  Hello, <s:property value="#request.empVO.ename" />  【OGNL取值】</LI>        
        <LI>  Hello, <s:property value="#request.empVO.sal" />  【OGNL取值】</LI>        
        <LI>  Hello, <s:property value="#request.empVO.hiredate" />  【OGNL取值】</LI>        
        <LI>  Hello, <s:property value="#request.empVO.hiretime" />  【OGNL取值】</LI>        
        
 </UL>
</body>
</html>
