package com.dept.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OrderBy;
import com.emp.model.EmpVO;

@Entity
@Table(name = "DEPT2")
public class DeptVO implements java.io.Serializable {

	private Integer deptno;
	private String dname;
	private String loc;
	private Set<EmpVO> emps = new HashSet<EmpVO>();

	public DeptVO() {
	}

	@Id
	@Column(name = "DEPTNO")
	@SequenceGenerator(name="xxx", allocationSize=1) //1.����@SequenceGenerator�إߤ@��generator
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx")       //2.�A��@GeneratedValue��generator�ݩʫ��w�n�έ���generator //�istrategy��GenerationType, ���|�ح�: AUTO, IDENTITY, SEQUENCE, TABLE�j 
	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Column(name = "DNAME")
	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Column(name = "LOC")
	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="deptVO")
	@OrderBy("empno asc")
	//��1:�i�{�b�O�]�w�� cascade="all" lazy="false" inverse="true"���N�j
	//��2:�imappedBy="�h�誺���p�ݩʦW"�G�Φb���V���p���A�����Y�������v����j�ideptVO�OEmpVO���ݩʡj
	//��3:�i��w�]��@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")���N�j--> �i�O���쬰  lazy="true"  inverse="true"���N�j
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
	public Set<EmpVO> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<EmpVO> emps) {
		this.emps = emps;
	}

}
