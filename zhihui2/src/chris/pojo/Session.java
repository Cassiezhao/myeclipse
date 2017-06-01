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

/**
 * Session entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "session", catalog = "zhineng")
public class Session implements java.io.Serializable {

	// Fields

	private Integer sessionId;
	private Guide guide;
	private Integer state;
	private String guidemnum;
	private Integer timer;
	@Column(name = "timer")
	public Integer getTimer() {
		return timer;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}

	@Column(name = "guidemnum", length = 9)
	public String getGuidemnum() {
		return guidemnum;
	}

	public void setGuidemnum(String guidemnum) {
		this.guidemnum = guidemnum;
	}

	private String score;
	private String info;
	private Integer person;
	private String onlineP;
	private String uplineP;
	private Timestamp onlineT;
	private Timestamp uplineT;
	
	private Set<Total> totals = new HashSet<Total>(0);

	// Constructors

	/** default constructor */
	public Session() {
	}

	/** minimal constructor */
	public Session(Timestamp uplineT) {
		this.uplineT = uplineT;
	}

	/** full constructor */
	public Session(Guide guide, Integer state, String score, String info,
			Integer person, String onlineP, String uplineP, Timestamp onlineT,
			Timestamp uplineT, Set<Total> totals,String guidemnum) {
		this.guide = guide;
		this.state = state;
		this.score = score;
		this.info = info;
		this.person = person;
		this.onlineP = onlineP;
		this.uplineP = uplineP;
		this.onlineT = onlineT;
		this.uplineT = uplineT;
		this.totals = totals;
		this.guidemnum=guidemnum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sessionId", unique = true, nullable = false)
	public Integer getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guideId")
	public Guide getGuide() {
		return this.guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "score")
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Column(name = "info", length = 20)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "person")
	public Integer getPerson() {
		return this.person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	@Column(name = "onlineP", length = 20)
	public String getOnlineP() {
		return this.onlineP;
	}

	public void setOnlineP(String onlineP) {
		this.onlineP = onlineP;
	}

	@Column(name = "uplineP", length = 20)
	public String getUplineP() {
		return this.uplineP;
	}

	public void setUplineP(String uplineP) {
		this.uplineP = uplineP;
	}

	@Column(name = "onlineT", length = 19)
	public Timestamp getOnlineT() {
		return this.onlineT;
	}

	public void setOnlineT(Timestamp onlineT) {
		this.onlineT = onlineT;
	}

	@Column(name = "uplineT", length = 19)
	public Timestamp getUplineT() {
		return this.uplineT;
	}

	public void setUplineT(Timestamp uplineT) {
		this.uplineT = uplineT;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "session")
	public Set<Total> getTotals() {
		return this.totals;
	}

	public void setTotals(Set<Total> totals) {
		this.totals = totals;
	}

}