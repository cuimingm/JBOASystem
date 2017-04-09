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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DEPARTMENTS", schema = "SCOTT", uniqueConstraints = @UniqueConstraint(columnNames = "DEPT_NAME"))
public class Department implements java.io.Serializable {

	// Fields

	private Integer deptNo;
	private String deptName;
	private Set<Employee> employees = new HashSet<Employee>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String deptName) {
		this.deptName = deptName;
	}

	/** full constructor */
	public Department(String deptName, Set<Employee> employees) {
		this.deptName = deptName;
		this.employees = employees;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_dept")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "DEPT_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "DEPT_NAME", unique = true, nullable = false, length = 20)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}