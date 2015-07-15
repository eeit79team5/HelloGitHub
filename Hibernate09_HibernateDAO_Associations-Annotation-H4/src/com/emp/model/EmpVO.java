package com.emp.model;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dept.model.DeptVO;

/*
 * 註1: classpath必須有hibernate-jpa-2.0-api-1.0.0.Final.jar 
 * 註2: Annotation可以添加在屬性上，也可以添加在getXxx()方法之上
 */


@Entity  //要加上@Entity才能成為JPA的一個Entity類別
@Table(name = "EMP2") //代表這個class是對應到資料庫的實體table，目前對應的table是EMP2 
public class EmpVO implements java.io.Serializable {

	private Integer empno;
	private DeptVO deptVO;
	private String ename;
	private String job;
	private Date hiredate;
	private Double sal;
	private Double comm;

	public EmpVO() { //必需有一個不傳參數建構子(JavaBean基本知識)
	}

	@Id //@Id代表這個屬性是這個Entity的唯一識別屬性，並且對映到Table的主鍵 
	@Column(name = "EMPNO")  //@Column指這個屬性是對應到資料庫Table的哪一個欄位   //【非必要，但當欄位名稱與屬性名稱不同時則一定要用】
	@SequenceGenerator(name="xxx", allocationSize=1) //1.先用@SequenceGenerator建立一個generator
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx")      //2.再用@GeneratedValue的generator屬性指定要用哪個generator //【strategy的GenerationType, 有四種值: AUTO, IDENTITY, SEQUENCE, TABLE】 
	public Integer getEmpno() {
		return this.empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@ManyToOne //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "DEPTNO")  //指定用來join table的column
	public DeptVO getDeptVO() {
		return this.deptVO;
	}

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}

	@Column(name = "ENAME")
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "JOB")
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

//	@Temporal 
//	1.用來指定型態為java.util.Date, java.util.Calendar的mapping.
//	2.TemporalType, 有DATE(mapping到java.sql.Date), 
//	                  TIME(mapping到java.sql.Time), 
//	                  TIMESTAMP(mapping到java.sql.Timestamp)(預設值)
//	3.如果型態本來就是java.sql.Date, java.sql.Time, java.sql.Timestamp, 就不用@Temporal 
//	4.【這範例有import java.util.Date;】-->【是故意用java.util.Date做練習，所以一定要加@Temporal 】
	@Temporal(TemporalType.DATE)
	@Column(name = "HIREDATE")
	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "SAL")
	public Double getSal() {
		return this.sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Column(name = "COMM")
	public Double getComm() {
		return this.comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

}
