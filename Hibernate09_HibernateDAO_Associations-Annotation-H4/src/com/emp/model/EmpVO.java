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
 * ��1: classpath������hibernate-jpa-2.0-api-1.0.0.Final.jar 
 * ��2: Annotation�i�H�K�[�b�ݩʤW�A�]�i�H�K�[�bgetXxx()��k���W
 */


@Entity  //�n�[�W@Entity�~�ন��JPA���@��Entity���O
@Table(name = "EMP2") //�N��o��class�O�������Ʈw������table�A�ثe������table�OEMP2 
public class EmpVO implements java.io.Serializable {

	private Integer empno;
	private DeptVO deptVO;
	private String ename;
	private String job;
	private Date hiredate;
	private Double sal;
	private Double comm;

	public EmpVO() { //���ݦ��@�Ӥ��ǰѼƫغc�l(JavaBean�򥻪���)
	}

	@Id //@Id�N��o���ݩʬO�o��Entity���ߤ@�ѧO�ݩʡA�åB��M��Table���D�� 
	@Column(name = "EMPNO")  //@Column���o���ݩʬO�������ƮwTable�����@�����   //�i�D���n�A�������W�ٻP�ݩʦW�٤��P�ɫh�@�w�n�Ρj
	@SequenceGenerator(name="xxx", allocationSize=1) //1.����@SequenceGenerator�إߤ@��generator
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="xxx")      //2.�A��@GeneratedValue��generator�ݩʫ��w�n�έ���generator //�istrategy��GenerationType, ���|�ح�: AUTO, IDENTITY, SEQUENCE, TABLE�j 
	public Integer getEmpno() {
		return this.empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@ManyToOne //(���V�h��@/�@��h)���h��@    //�i��w�]�� @ManyToOne(fetch=FetchType.LAZY)�j--> �i�O���쬰lazy="true"���N�j
	@JoinColumn(name = "DEPTNO")  //���w�Ψ�join table��column
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
//	1.�Ψӫ��w���A��java.util.Date, java.util.Calendar��mapping.
//	2.TemporalType, ��DATE(mapping��java.sql.Date), 
//	                  TIME(mapping��java.sql.Time), 
//	                  TIMESTAMP(mapping��java.sql.Timestamp)(�w�]��)
//	3.�p�G���A���ӴN�Ojava.sql.Date, java.sql.Time, java.sql.Timestamp, �N����@Temporal 
//	4.�i�o�d�Ҧ�import java.util.Date;�j-->�i�O�G�N��java.util.Date���m�ߡA�ҥH�@�w�n�[@Temporal �j
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
