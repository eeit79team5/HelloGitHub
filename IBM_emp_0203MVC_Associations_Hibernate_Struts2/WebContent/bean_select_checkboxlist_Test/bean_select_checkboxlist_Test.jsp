<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import=" java.util.*"%>
<%@ page import="com.dept.model.DeptVO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>bean_select_checkboxlist_Test.jsp</title>
<s:head theme="xhtml"  /><!-- �w�] -->
</head>
<body bgcolor='white'  >
<h3><font color="red"> �N select �אּ checkboxlist �Y���֨����</font></h3>

              <s:select name="empVO.deptVO.deptno" label="���u����" list="{'�]�ȳ�','��o��','�~�ȳ�','�ͺ޳�'}"/>

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>
             
              <s:select name="empVO.deptVO.deptno" label="���u����" list="#{'10':'�]�ȳ�', '20':'��o��', '30':'�~�ȳ�', '40':'�ͺ޳�'}" listKey="key" listValue="value" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>

        <%    List<DeptVO> list1 = new  ArrayList<DeptVO>();
              DeptVO deptVO1 = new DeptVO();  deptVO1.setDeptno(10);  deptVO1.setDname("�]�ȳ�");  deptVO1.setLoc("�O�W�x�_");
              DeptVO deptVO2 = new DeptVO();  deptVO2.setDeptno(20);  deptVO2.setDname("��o��");  deptVO2.setLoc("�O�W�s��");
              DeptVO deptVO3 = new DeptVO();  deptVO3.setDeptno(30);  deptVO3.setDname("�~�ȳ�");  deptVO3.setLoc("����ì�");
              DeptVO deptVO4 = new DeptVO();  deptVO4.setDeptno(40);  deptVO4.setDname("�ͺ޳�");  deptVO4.setLoc("����W��");
              list1.add(deptVO1 );
              list1.add(deptVO2 );
              list1.add(deptVO3 );
              list1.add(deptVO4 );
              request.setAttribute("list1",list1); %>
              <s:select name="empVO.deptVO.deptno" label="���u����" labelposition="center" list="#request.list1" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>
		
		<%    com.dept.model.DeptService deptSvc2 = new com.dept.model.DeptService();
              List<DeptVO> list2 = deptSvc2.getAll();
              request.setAttribute("list2",list2); %>
              <s:select name="empVO.deptVO.deptno" label="���u����" labelposition="center" list="#request.list2" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>

              <jsp:useBean id="deptSvc3" scope="request" class="com.dept.model.DeptService" />
		      <s:select name="empVO.deptVO.deptno" label="���u����" labelposition="center" list="#request.deptSvc3.all" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>
        
              <s:bean id="deptSvc4" name="com.dept.model.DeptService"  />
		      <s:select name="empVO.deptVO.deptno" label="���u����" labelposition="center" list="#deptSvc4.all" listKey="deptno" listValue="dname" />

<br>-------------------------------------------------------------------------------------------------------------------------------------------------------<br>

</body>
</html>

