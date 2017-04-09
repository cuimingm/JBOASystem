package net.jboasystem.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reimbursement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REIMBURSEMENTS", schema = "SCOTT")
public class Reimbursement implements java.io.Serializable {

	// Fields

	private Integer reimNo;
	private Employee employeeByNextCheckEmpNo;
	private Employee employeeByReimEmpNo;
	private String reimReason;
	private Double reimTotalMoney;
	private Date reimTime;
	private Boolean reimStatus;
	private Date createTime;
	private Date lastUpdateTime;
	private Set<ReimbursementDetail> reimbursementDetails = new HashSet<ReimbursementDetail>(
			0);

	// Constructors

	/** default constructor */
	public Reimbursement() {
	}

	/** minimal constructor */
	public Reimbursement(Employee employeeByNextCheckEmpNo,
			Employee employeeByReimEmpNo, String reimReason,
			Double reimTotalMoney, Date reimTime, Boolean reimStatus,
			Date createTime, Date lastUpdateTime) {
		this.employeeByNextCheckEmpNo = employeeByNextCheckEmpNo;
		this.employeeByReimEmpNo = employeeByReimEmpNo;
		this.reimReason = reimReason;
		this.reimTotalMoney = reimTotalMoney;
		this.reimTime = reimTime;
		this.reimStatus = reimStatus;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	/** full constructor */
	public Reimbursement(Employee employeeByNextCheckEmpNo,
			Employee employeeByReimEmpNo, String reimReason,
			Double reimTotalMoney, Date reimTime, Boolean reimStatus,
			Date createTime, Date lastUpdateTime,
			Set<ReimbursementDetail> reimbursementDetails) {
		this.employeeByNextCheckEmpNo = employeeByNextCheckEmpNo;
		this.employeeByReimEmpNo = employeeByReimEmpNo;
		this.reimReason = reimReason;
		this.reimTotalMoney = reimTotalMoney;
		this.reimTime = reimTime;
		this.reimStatus = reimStatus;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.reimbursementDetails = reimbursementDetails;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_reim")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "REIM_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getReimNo() {
		return this.reimNo;
	}

	public void setReimNo(Integer reimNo) {
		this.reimNo = reimNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEXT_CHECK_EMP_NO", nullable = false)
	public Employee getEmployeeByNextCheckEmpNo() {
		return this.employeeByNextCheckEmpNo;
	}

	public void setEmployeeByNextCheckEmpNo(Employee employeeByNextCheckEmpNo) {
		this.employeeByNextCheckEmpNo = employeeByNextCheckEmpNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REIM_EMP_NO", nullable = false)
	public Employee getEmployeeByReimEmpNo() {
		return this.employeeByReimEmpNo;
	}

	public void setEmployeeByReimEmpNo(Employee employeeByReimEmpNo) {
		this.employeeByReimEmpNo = employeeByReimEmpNo;
	}

	@Column(name = "REIM_REASON", nullable = false, length = 200)
	public String getReimReason() {
		return this.reimReason;
	}

	public void setReimReason(String reimReason) {
		this.reimReason = reimReason;
	}

	@Column(name = "REIM_TOTAL_MONEY", nullable = false, precision = 8)
	public Double getReimTotalMoney() {
		return this.reimTotalMoney;
	}

	public void setReimTotalMoney(Double reimTotalMoney) {
		this.reimTotalMoney = reimTotalMoney;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REIM_TIME", nullable = false, length = 7)
	public Date getReimTime() {
		return this.reimTime;
	}

	public void setReimTime(Date reimTime) {
		this.reimTime = reimTime;
	}

	@Column(name = "REIM_STATUS", nullable = false, precision = 1, scale = 0)
	public Boolean getReimStatus() {
		return this.reimStatus;
	}

	public void setReimStatus(Boolean reimStatus) {
		this.reimStatus = reimStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_TIME", nullable = false, length = 7)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_TIME", nullable = false, length = 7)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reimbursement")
	public Set<ReimbursementDetail> getReimbursementDetails() {
		return this.reimbursementDetails;
	}

	public void setReimbursementDetails(
			Set<ReimbursementDetail> reimbursementDetails) {
		this.reimbursementDetails = reimbursementDetails;
	}

}