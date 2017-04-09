package net.jboasystem.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CheckedResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHECKED_RESULTS", schema = "SCOTT")
public class CheckedResult implements java.io.Serializable {

	// Fields

	private Integer checkedNo;
	private Employee employee;
	private int checkedType;
	private Integer checkedItemNo;
	private Date checkedTime;
	private int checkedResult;
	private String chenckedIdea;

	// Constructors

	/** default constructor */
	public CheckedResult() {
	}

	/** full constructor */
	public CheckedResult(Employee employee, int checkedType,
			Integer checkedItemNo, Date checkedTime, int checkedResult,
			String chenckedIdea) {
		this.employee = employee;
		this.checkedType = checkedType;
		this.checkedItemNo = checkedItemNo;
		this.checkedTime = checkedTime;
		this.checkedResult = checkedResult;
		this.chenckedIdea = chenckedIdea;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_check")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "CHECKED_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getCheckedNo() {
		return this.checkedNo;
	}

	public void setCheckedNo(Integer checkedNo) {
		this.checkedNo = checkedNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHECKED_EMP_NO", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "CHECKED_TYPE", nullable = false, precision = 1, scale = 0)
	public int getCheckedType() {
		return this.checkedType;
	}

	public void setCheckedType(int checkedType) {
		this.checkedType = checkedType;
	}

	@Column(name = "CHECKED_ITEM_NO", nullable = false, precision = 6, scale = 0)
	public Integer getCheckedItemNo() {
		return this.checkedItemNo;
	}

	public void setCheckedItemNo(Integer checkedItemNo) {
		this.checkedItemNo = checkedItemNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHECKED_TIME", nullable = false, length = 7)
	public Date getCheckedTime() {
		return this.checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	@Column(name = "CHECKED_RESULT", nullable = false, precision = 1, scale = 0)
	public int getCheckedResult() {
		return this.checkedResult;
	}

	public void setCheckedResult(int checkedResult) {
		this.checkedResult = checkedResult;
	}

	@Column(name = "CHENCKED_IDEA", nullable = false, length = 50)
	public String getChenckedIdea() {
		return this.chenckedIdea;
	}

	public void setChenckedIdea(String chenckedIdea) {
		this.chenckedIdea = chenckedIdea;
	}

}