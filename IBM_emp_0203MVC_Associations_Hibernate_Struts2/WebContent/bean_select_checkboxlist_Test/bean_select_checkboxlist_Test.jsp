<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import=" java.util.*"%>
<%@ page import="com.dept.model.DeptVO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>bean_select_checkboxlist_Test.jsp</title>
<s:head theme="xhtml"  /><!-- 箇砞 -->
</head>
<body bgcolor='white'  >
<h3><font color="red"> 盢 select э checkboxlist よ遏</font></h3>

              <s:select name="empVO.deptVO.deptno" label="场" list="{'癩叭场','祇场','穨叭场','ネ恨场'}"/>

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>
             
              <s:select name="empVO.deptVO.deptno" label="场" list="#{'10':'癩叭场', '20':'祇场', '30':'穨叭场', '40':'ネ恨场'}" listKey="key" listValue="value" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>

        <%    List<DeptVO> list1 = new  ArrayList<DeptVO>();
              DeptVO deptVO1 = new DeptVO();  deptVO1.setDeptno(10);  deptVO1.setDname("癩叭场");  deptVO1.setLoc("籓芖");
              DeptVO deptVO2 = new DeptVO();  deptVO2.setDeptno(20);  deptVO2.setDname("祇场");  deptVO2.setLoc("籓芖穝λ");
              DeptVO deptVO3 = new DeptVO();  deptVO3.setDeptno(30);  deptVO3.setDname("穨叭场");  deptVO3.setLoc("瓣");
              DeptVO deptVO4 = new DeptVO();  deptVO4.setDeptno(40);  deptVO4.setDname("ネ恨场");  deptVO4.setLoc("い瓣");
              list1.add(deptVO1 );
              list1.add(deptVO2 );
              list1.add(deptVO3 );
              list1.add(deptVO4 );
              request.setAttribute("list1",list1); %>
              <s:select name="empVO.deptVO.deptno" label="场" labelposition="center" list="#request.list1" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>
		
		<%    com.dept.model.DeptService deptSvc2 = new com.dept.model.DeptService();
              List<DeptVO> list2 = deptSvc2.getAll();
              request.setAttribute("list2",list2); %>
              <s:select name="empVO.deptVO.deptno" label="场" labelposition="center" list="#request.list2" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>

              <jsp:useBean id="deptSvc3" scope="request" class="com.dept.model.DeptService" />
		      <s:select name="empVO.deptVO.deptno" label="场" labelposition="center" list="#request.deptSvc3.all" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>
        
              <s:bean id="deptSvc4" name="com.dept.model.DeptService"  />
		      <s:select name="empVO.deptVO.deptno" label="场" labelposition="center" list="#deptSvc4.all" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>

</body>
</html>

