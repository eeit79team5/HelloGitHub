package com.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.emp.model.EmpDAO;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	private EmpVO empVO;

	public EmpVO getEmpVO() {
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}

	public String add() {
		EmpService empSvc = new EmpService();
		empSvc.addEmp(empVO);
		System.out.println(" 資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		EmpService empSvc = new EmpService();
		EmpVO empVO2 = empSvc.updateEmp(empVO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("empVO", empVO2);
		System.out.println("  資料庫 update 成功");
		return "success";
	}

}
