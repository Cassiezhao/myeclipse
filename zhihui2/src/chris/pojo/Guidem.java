package chris.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Guidem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guidem", catalog = "zhineng")
public class Guidem implements java.io.Serializable {

	// Fields
	
	private Integer guidemid;
	private Guide guide;
	private String guidemnum;
	private Integer borrow;
	private Integer break_;
	private Integer gmstate;
	private Timestamp assignTime;
	private String breakinfo;
	private Timestamp broT;
	private Timestamp retT;
	private Integer youkeNum;
	private String sendmessage;
	private String ChangeCheck;
	private String gmtel;
	private Integer mkdir;
	private Integer mkstatus;
	private String mydir;
	private Integer connectionID;
	private	Integer listennum;
	private Integer recordtime;
	@Column(name="recordtime")
	public Integer getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Integer recordtime) {
		this.recordtime = recordtime;
	}

	@Column(name="listennum")
	public Integer getListennum() {
		return listennum;
	}

	public void setListennum(Integer listennum) {
		this.listennum = listennum;
	}

	@Column(name="connectionID")
	public Integer getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(Integer connectionID) {
		this.connectionID = connectionID;
	}

	@Column(name="mydir")
	public String getMydir() {
		return mydir;
	}

	public void setMydir(String mydir) {
		this.mydir = mydir;
	}

	@Column(name = "mkdir")
	public Integer getMkdir() {
		return mkdir;
	}

	public void setMkdir(Integer mkdir) {
		this.mkdir = mkdir;
	}
	@Column(name = "mkstatus")
	public Integer getMkstatus() {
		return mkstatus;
	}

	public void setMkstatus(Integer mkstatus) {
		this.mkstatus = mkstatus;
	}

	@Column(name = "gmtel")
	public String getGmtel() {
		return gmtel;
	}

	public void setGmtel(String gmtel) {
		this.gmtel = gmtel;
	}

	@Column(name = "ChangeCheck")
	public String getChangeCheck() {
		return ChangeCheck;
	}

	public void setChangeCheck(String changeCheck) {
		ChangeCheck = changeCheck;
	}

	@Column(name = "sendmessage")
	public String getSendmessage() {
		return sendmessage;
	}

	public void setSendmessage(String sendmessage) {
		this.sendmessage = sendmessage;
	}

	@Column(name = "youkeNum")
	public Integer getYoukeNum() {
		return youkeNum;
	}

	public void setYoukeNum(Integer youkeNum) {
		this.youkeNum = youkeNum;
	}

	private Set<Guide> guides = new HashSet<Guide>(0);

	// Constructors

	/** default constructor */
	public Guidem() {
	}

	/** full constructor */
	public Guidem(Guide guide, String guidemnum, Integer borrow,
			Integer break_, Integer gmstate, Timestamp assignTime, String breakinfo,
			Timestamp broT, Timestamp retT, Set<Guide> guides) {
		this.guide = guide;
		this.guidemnum = guidemnum;
		this.borrow = borrow;
		this.break_ = break_;
		this.gmstate = gmstate;
		this.assignTime = assignTime;
		this.breakinfo = breakinfo;
		this.broT = broT;
		this.retT = retT;
		this.guides = guides;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "guidemid", unique = true, nullable = false)
	public Integer getGuidemid() {
		return this.guidemid;
	}

	public void setGuidemid(Integer guidemid) {
		this.guidemid = guidemid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guideid")
	public Guide getGuide() {
		return this.guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	@Column(name = "guidemnum")
	public String getGuidemnum() {
		return this.guidemnum;
	}

	public void setGuidemnum(String guidemnum) {
		this.guidemnum = guidemnum;
	}

	@Column(name = "borrow")
	public Integer getBorrow() {
		return this.borrow;
	}

	public void setBorrow(Integer borrow) {
		this.borrow = borrow;
	}

	@Column(name = "break")
	public Integer getBreak_() {
		return this.break_;
	}

	public void setBreak_(Integer break_) {
		this.break_ = break_;
	}

	@Column(name = "gmstate")
	public Integer getGmstate() {
		return this.gmstate;
	}

	public void setGmstate(Integer gmstate) {
		this.gmstate = gmstate;
	}

	@Column(name = "assignTime")
	public Timestamp getAssignTime() {
		return this.assignTime;
	}

	public void setAssignTime(Timestamp assignTime) {
		this.assignTime = assignTime;
	}

	@Column(name = "breakinfo", length = 30)
	public String getBreakinfo() {
		return this.breakinfo;
	}

	public void setBreakinfo(String breakinfo) {
		this.breakinfo = breakinfo;
	}

	@Column(name = "broT")
	public Timestamp getBroT() {
		return this.broT;
	}

	public void setBroT(Timestamp broT) {
		this.broT = broT;
	}

	@Column(name = "retT")
	public Timestamp getRetT() {
		return this.retT;
	}

	public void setRetT(Timestamp retT) {
		this.retT = retT;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "guidem")
	public Set<Guide> getGuides() {
		return this.guides;
	}

	public void setGuides(Set<Guide> guides) {
		this.guides = guides;
	}

}