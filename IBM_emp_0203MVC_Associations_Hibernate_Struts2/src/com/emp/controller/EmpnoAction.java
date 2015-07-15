package com.emp.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class EmpnoAction extends ActionSupport {
	private Integer empno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Display 成功");
			return "success";
		} else {
			super.addFieldError("ename", "查無資料");
			return "input";
		}
	}

	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Update 成功");
			return "success";
		} else {
			super.addFieldError("ename", "查無資料");
			return "input";
		}
	}

	public boolean getOne() {
		EmpService empSvc = new EmpService();
		EmpVO empVO = empSvc.getOneEmp(empno);
		if (empVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("empVO", empVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		EmpService empSvc = new EmpService();
		empSvc.deleteEmp(empno);
		System.out.println(" 資料庫 delete 成功");
		return "success";
	}

}
