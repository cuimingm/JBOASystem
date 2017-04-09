package net.jboasystem.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EMPLOYEES", schema = "SCOTT")
public class Employee implements java.io.Serializable {

	// Fields

	private Integer empNo;
	private Job job;
	private Department department;
	private String empName;
	private String loginPassword;
	private Boolean empStatus;
	private Set<Leave> leavesForNextCheckEmpNo = new HashSet<Leave>(0);
	private Set<Reimbursement> reimbursementsForReimEmpNo = new HashSet<Reimbursement>(
			0);
	private Set<Leave> leavesForLeaveEmpNo = new HashSet<Leave>(0);
	private Set<Reimbursement> reimbursementsForNextCheckEmpNo = new HashSet<Reimbursement>(
			0);
	private Set<CheckedResult> checkedResults = new HashSet<CheckedResult>(0);

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Job job, Department department, String empName,
			String loginPassword, Boolean empStatus) {
		this.job = job;
		this.department = department;
		this.empName = empName;
		this.loginPassword = loginPassword;
		this.empStatus = empStatus;
	}

	/** full constructor */
	public Employee(Job job, Department department, String empName,
			String loginPassword, Boolean empStatus,
			Set<Leave> leavesForNextCheckEmpNo,
			Set<Reimbursement> reimbursementsForReimEmpNo,
			Set<Leave> leavesForLeaveEmpNo,
			Set<Reimbursement> reimbursementsForNextCheckEmpNo,
			Set<CheckedResult> checkedResults) {
		this.job = job;
		this.department = department;
		this.empName = empName;
		this.loginPassword = loginPassword;
		this.empStatus = empStatus;
		this.leavesForNextCheckEmpNo = leavesForNextCheckEmpNo;
		this.reimbursementsForReimEmpNo = reimbursementsForReimEmpNo;
		this.leavesForLeaveEmpNo = leavesForLeaveEmpNo;
		this.reimbursementsForNextCheckEmpNo = reimbursementsForNextCheckEmpNo;
		this.checkedResults = checkedResults;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_emp")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "EMP_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_NO", nullable = false)
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_NO", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "EMP_NAME", nullable = false, length = 20)
	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name = "LOGIN_PASSWORD", nullable = false, length = 20)
	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Column(name = "EMP_STATUS", nullable = false, precision = 1, scale = 0)
	public Boolean getEmpStatus() {
		return this.empStatus;
	}

	public void setEmpStatus(Boolean empStatus) {
		this.empStatus = empStatus;
	}

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "employeeByNextCheckEmpNo")
	public Set<Leave> getLeavesForNextCheckEmpNo() {
		return this.leavesForNextCheckEmpNo;
	}

	public void setLeavesForNextCheckEmpNo(Set<Leave> leavesForNextCheckEmpNo) {
		this.leavesForNextCheckEmpNo = leavesForNextCheckEmpNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeByReimEmpNo")
	public Set<Reimbursement> getReimbursementsForReimEmpNo() {
		return this.reimbursementsForReimEmpNo;
	}

	public void setReimbursementsForReimEmpNo(
			Set<Reimbursement> reimbursementsForReimEmpNo) {
		this.reimbursementsForReimEmpNo = reimbursementsForReimEmpNo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByLeaveEmpNo")
	public Set<Leave> getLeavesForLeaveEmpNo() {
		return this.leavesForLeaveEmpNo;
	}

	public void setLeavesForLeaveEmpNo(Set<Leave> leavesForLeaveEmpNo) {
		this.leavesForLeaveEmpNo = leavesForLeaveEmpNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeByNextCheckEmpNo")
	public Set<Reimbursement> getReimbursementsForNextCheckEmpNo() {
		return this.reimbursementsForNextCheckEmpNo;
	}

	public void setReimbursementsForNextCheckEmpNo(
			Set<Reimbursement> reimbursementsForNextCheckEmpNo) {
		this.reimbursementsForNextCheckEmpNo = reimbursementsForNextCheckEmpNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<CheckedResult> getCheckedResults() {
		return this.checkedResults;
	}

	public void setCheckedResults(Set<CheckedResult> checkedResults) {
		this.checkedResults = checkedResults;
	}

}