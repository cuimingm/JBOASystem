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
 * Job entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "JOBS", schema = "SCOTT", uniqueConstraints = @UniqueConstraint(columnNames = "JOB_NAME"))
public class Job implements java.io.Serializable {

	// Fields

	private Integer jobNo;
	private String jobName;
	private Set<Employee> employees = new HashSet<Employee>(0);

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** minimal constructor */
	public Job(String jobName) {
		this.jobName = jobName;
	}

	/** full constructor */
	public Job(String jobName, Set<Employee> employees) {
		this.jobName = jobName;
		this.employees = employees;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_job")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "JOB_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getJobNo() {
		return this.jobNo;
	}

	public void setJobNo(Integer jobNo) {
		this.jobNo = jobNo;
	}

	@Column(name = "JOB_NAME", unique = true, nullable = false, length = 20)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}