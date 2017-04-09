package net.jboasystem.entity;

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

/**
 * ReimbursementDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REIM_DETAILS", schema = "SCOTT")
public class ReimbursementDetail implements java.io.Serializable {

	// Fields

	private Integer detailNo;
	private Reimbursement reimbursement;
	private String reimItemType;
	private Double itemMoney;
	private String itemReason;

	// Constructors

	/** default constructor */
	public ReimbursementDetail() {
	}

	/** full constructor */
	public ReimbursementDetail(Reimbursement reimbursement,
			String reimItemType, Double itemMoney, String itemReason) {
		this.reimbursement = reimbursement;
		this.reimItemType = reimItemType;
		this.itemMoney = itemMoney;
		this.itemReason = itemReason;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_detail")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "DETAIL_NO", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getDetailNo() {
		return this.detailNo;
	}

	public void setDetailNo(Integer detailNo) {
		this.detailNo = detailNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REIM_NO", nullable = false)
	public Reimbursement getReimbursement() {
		return this.reimbursement;
	}

	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}

	@Column(name = "REIM_ITEM_TYPE", nullable = false, length = 20)
	public String getReimItemType() {
		return this.reimItemType;
	}

	public void setReimItemType(String reimItemType) {
		this.reimItemType = reimItemType;
	}

	@Column(name = "ITEM_MONEY", nullable = false, precision = 6)
	public Double getItemMoney() {
		return this.itemMoney;
	}

	public void setItemMoney(Double itemMoney) {
		this.itemMoney = itemMoney;
	}

	@Column(name = "ITEM_REASON", nullable = false, length = 200)
	public String getItemReason() {
		return this.itemReason;
	}

	public void setItemReason(String itemReason) {
		this.itemReason = itemReason;
	}

}