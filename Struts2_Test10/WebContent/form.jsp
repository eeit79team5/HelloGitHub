<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>form.jsp</title>
<s:head theme="xhtml" /> <!--�w�]�� xhtml --> <!--theme �i�� xhtml �� simple �� css_xhtml --> 
<sx:head debug="false" cache="false" parseContent="false"	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
</head>
<body onLoad="setValue()"><br>
<OL>

<!--         <LI><font color="blue"><b>�ǲΪ�Html����</b></font> -->
        <s:fielderror cssStyle="color:blue"/>
<%--         <form action="<%=request.getContextPath()%>/myNamespace/myAction!add.action"	method="post"> --%>
<!-- 			     ���u�m�W:  -->
<!-- 			    <input type="text" name="empVO.ename" value="peter1�d�ç�" /><p> -->
			    
<!-- 			     ���usal: -->
<!-- 			    <input type="text" name="empVO.sal"/><p>	 -->
<!-- 			     ���ucomm:  -->
<!-- 			    <input type="text" name="empVO.comm" value="100" /><p> -->
<!-- 			     ���udeptno:  -->
<!-- 			    <input type="text" name="empVO.deptno" value="10" /><p> -->
<!-- 				<input type="submit" /> -->
<!-- 		</form><BR>	</LI> -->
		
		
		<LI><font color="blue"><b>Struts2�����UI����</b></font>
		
		<s:form action="myAction" namespace="/myNamespace" >
			<s:textfield name="empVO.ename" label="���u�m�W"  value="peter" />
			<s:textfield name="empVO.job" label="���u¾��"  value="manager" />						
<sx:datetimepicker type="date"  name="empVO.hiredate"  label="�o����"  displayFormat="yyyy-MM-dd "   id="picker1"  language="zh-tw"  required="true"   cssStyle="background:cyan ;  font-size:13.5px"/>
<sx:datetimepicker type="time"  name="empVO.hiretime"  label="�o��ɶ�"  displayFormat="HH:mm:ss "   id="picker2"  language="zh-tw"  required="true"   cssStyle="background:cyan ;  font-size:13.5px"/>			
			<s:textfield name="empVO.sal" label="���usal"  />
			<s:textfield name="empVO.comm" label="���ucomm"  value="100" />
			<s:textfield name="empVO.deptno" label="���udeptno"  value="10" />						
			<s:submit method="add" value="�e�X" />
		</s:form></LI>
        
</OL>
	<script type="text/javascript">
		function setValue() {
			document.getElementById('picker1').children[1].setAttribute("readOnly","true");
			var picker1 = dojo.widget.byId("picker1");
			if (picker1.getValue() == "")
				picker1.setValue(new Date()); //Date value  //picker.setValue('2007-01-01');  //string value
		}
		function setValue() {
			document.getElementById('picker2').children[1].setAttribute("readOnly","true");
			var picker2 = dojo.widget.byId("picker2");
			if (picker2.getValue() == "")
				picker2.setValue(new Time());
		}		
	</script>
</body>
</html>