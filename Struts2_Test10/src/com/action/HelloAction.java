package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.opensymphony.xwork2.ActionSupport;

//import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionSupport;

// ��1: �p�G Action ���O�O�@�� POJO , ���{������ execute() method �O���n����
// ��2: �p�G implements Action ���� , �h����@�� public String execute() ��H��k
// ��3: �p�G extends ActionSupport ,  �h�i�٥h�� public String execute() ��k
public class HelloAction extends ActionSupport { 
	private EmpVO empVO;

	public EmpVO getEmpVO() {
		System.out.println("3. get ��k�Q view �� EL �� OGNL���Ȯɦ۰ʩI�s....................................................");
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		System.out.println("1. set ��k�Q Struts 2 �۰ʩI�s.....................................................");
		this.empVO = empVO;
	}

	//��1:  execute() method �n�^�Ǥ@�� String�A�o�� String �O�n�i�� Struts2 �b���槹 Action ����A�ҭn�ɦV������
	//��2:  �p�G�ڭ̦b Action �� execute() method ���^�Ǥ@�� "success" ���r��AStruts 2 �N�|�� struts.xml �� �� 
	//          action ���U��M�O�_���ŦX�� <result name="success"> �i�H����
	//��3:  �ڭ̥i�H�b Action ���Ҵ��Ѫ� execute() method �̥[�J�ڭ̪� business logic
	public String execute() {
		System.out.println("2. execute ��k�Q Struts 2 �۰ʩI�s.....................................................");
		return "success";
	}

	public String add() {
		EmpService empSvc = new EmpService();
		empSvc.addEmp(empVO);
		System.out.println("  add  ��k�Q Struts 2 �۰ʩI�s.....................................................");
		return "success";
	}	
	
//	public String execute() {
////		int i = 0;
////		int j = 1/i;
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		session.setAttribute("empVO", empVO);
//		System.out.println("2. execute ��k�Q Struts 2 �۰ʩI�s.....................................................");
//		return "success";
//	}
	
}
