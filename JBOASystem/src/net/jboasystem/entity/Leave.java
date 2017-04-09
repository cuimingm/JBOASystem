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
 * Leave entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LEAVES", schema = "SCOTT")
public class Leave implements java.io.Serializable {

	// Fields

	private Integer leaveNo;
	private Employee employeeByLeaveEmpNo;      //«ÎºŸ»À
	private Employee employeeByNextCheckEmpNo;	//…Û∫À»À
	private Integer leaveType;
	private String leaveReason;
	private Date leaveStartTime;
	private Date leaveEndTime;
	private Double leaveDateCount;
	private Integer leaveStatus;
	private Date createTime;

	// Constructors

	/** default constructor */
	public Leave() {
	}

	/** full constructor */
	public Leave(Employee employeeByLeaveEmpNo,
			Employee employeeByNextCheckEmpNo, Integer leaveType,
			String leaveReason, Date leaveStartTime, Date leaveEndTime,
			Double leaveDateCount, Integer leaveStatus, Date createTime) {
		this.employeeByLeaveEmpNo = employeeByLeaveEmpNo;
		this.employeeByNextCheckEmpNo = employeeByNextCheckEmpNo;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.leaveStartTime = leaveStartTime;
		this.leaveEndTime = leaveEndTime;
		this.leaveDateCount = leaveDateCount;
		this.leaveStatus = leaveStatus;
		this.createTime = createTime;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_leave")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "LEAVE_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getLeaveNo() {
		return this.leaveNo;
	}

	public void setLeaveNo(Integer leaveNo) {
		this.leaveNo = leaveNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAVE_EMP_NO", nullable = false)
	public Employee getEmployeeByLeaveEmpNo() {
		return this.employeeByLeaveEmpNo;
	}

	public void setEmployeeByLeaveEmpNo(Employee employeeByLeaveEmpNo) {
		this.employeeByLeaveEmpNo = employeeByLeaveEmpNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEXT_CHECK_EMP_NO", nullable = false)
	public Employee getEmployeeByNextCheckEmpNo() {
		return this.employeeByNextCheckEmpNo;
	}

	public void setEmployeeByNextCheckEmpNo(Employee employeeByNextCheckEmpNo) {
		this.employeeByNextCheckEmpNo = employeeByNextCheckEmpNo;
	}

	@Column(name = "LEAVE_TYPE", nullable = false)
	public Integer getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(Integer leaveType) {
		this.leaveType = leaveType;
	}

	@Column(name = "LEAVE_REASON", nullable = false, length = 200)
	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}


	@Column(name = "LEAVE_START_TIME", nullable = false)
	public Date getLeaveStartTime() {
		return this.leaveStartTime;
	}

	public void setLeaveStartTime(Date leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}


	@Column(name = "LEAVE_END_TIME", nullable = false)
	public Date getLeaveEndTime() {
		return this.leaveEndTime;
	}

	public void setLeaveEndTime(Date leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}

	@Column(name = "LEAVE_DATE_COUNT", nullable = false, precision = 3, scale = 1)
	public Double getLeaveDateCount() {
		return this.leaveDateCount;
	}

	public void setLeaveDateCount(Double leaveDateCount) {
		this.leaveDateCount = leaveDateCount;
	}

	@Column(name = "LEAVE_STATUS", nullable = false)
	public Integer getLeaveStatus() {
		return this.leaveStatus;
	}

	public void setLeaveStatus(Integer leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	
	@Column(name = "CREATE_TIME", nullable = false)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}