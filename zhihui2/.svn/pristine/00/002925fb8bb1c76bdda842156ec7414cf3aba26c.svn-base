package chris.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Total entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "total", catalog = "zhineng")
public class Total implements java.io.Serializable {

	// Fields

	private Integer totalId;
	private Session session;
	private Integer guideId;
	private Integer person;
	private String position;
	private Double jingdu;
	private Double weidu;
	
	private Double rawjing;
	private Double rawwei;
	private String bluenum;
	private Double bluejing;
	private Double bluewei;
	
	private Timestamp onlineTime;
	
	@Column(name = "onlineTime")
	public Timestamp getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Timestamp onlineTime) {
		this.onlineTime = onlineTime;
	}

	@Column(name = "rawjing", precision = 10, scale = 6)
	public Double getRawjing() {
		return rawjing;
	}

	public void setRawjing(Double rawjing) {
		this.rawjing = rawjing;
	}
	@Column(name = "rawwei", precision = 10, scale = 6)
	public Double getRawwei() {
		return rawwei;
	}

	public void setRawwei(Double rawwei) {
		this.rawwei = rawwei;
	}
	@Column(name = "bluenum")
	public String getBluenum() {
		return bluenum;
	}

	public void setBluenum(String bluenum) {
		this.bluenum = bluenum;
	}
	@Column(name = "bluejing")
	public Double getBluejing() {
		return bluejing;
	}

	public void setBluejing(Double bluejing) {
		this.bluejing = bluejing;
	}
	@Column(name = "bluewei")
	public Double getBluewei() {
		return bluewei;
	}

	public void setBluewei(Double bluewei) {
		this.bluewei = bluewei;
	}

	// Constructors
	@Column(name = "jingdu", precision = 10, scale = 6)
	public Double getJingdu() {
		return jingdu;
	}

	public void setJingdu(Double jingdu) {
		this.jingdu = jingdu;
	}
	@Column(name = "weidu", precision = 10, scale = 6)
	public Double getWeidu() {
		return weidu;
	}

	public void setWeidu(Double weidu) {
		this.weidu = weidu;
	}

	/** default constructor */
	public Total() {
	}

	/** full constructor */
	public Total(Session session, Integer guideId, Integer person,
			String position,Double jingdu,Double weidu) {
		this.session = session;
		this.guideId = guideId;
		this.person = person;
		this.position = position;
		this.jingdu=jingdu;
		this.weidu=weidu;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "totalId", unique = true, nullable = false)
	public Integer getTotalId() {
		return this.totalId;
	}

	public void setTotalId(Integer totalId) {
		this.totalId = totalId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sessionId")
	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Column(name = "guideId")
	public Integer getGuideId() {
		return this.guideId;
	}

	public void setGuideId(Integer guideId) {
		this.guideId = guideId;
	}

	@Column(name = "person")
	public Integer getPerson() {
		return this.person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	@Column(name = "position", length = 20)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}