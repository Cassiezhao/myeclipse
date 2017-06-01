package chris.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Buletooth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "buletooth", catalog = "zhineng")
public class Buletooth implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer blueid;
	private Integer bluenum;
	private Double jingdu;
	private Double weidu;
	private Timestamp time;
	
	
	// Constructors

	/** default constructor */
	public Buletooth() {
	}

	/** full constructor */
	public Buletooth(Integer bluenum, Double jingdu, Double weidu,
			Timestamp time) {
		this.bluenum = bluenum;
		this.jingdu = jingdu;
		this.weidu = weidu;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "blueid", unique = true, nullable = false)
	public Integer getBlueid() {
		return this.blueid;
	}

	public void setBlueid(Integer blueid) {
		this.blueid = blueid;
	}

	@Column(name = "bluenum")
	public Integer getBluenum() {
		return this.bluenum;
	}

	public void setBluenum(Integer bluenum) {
		this.bluenum = bluenum;
	}

	@Column(name = "jingdu", precision = 10, scale = 6)
	public Double getJingdu() {
		return this.jingdu;
	}

	public void setJingdu(Double jingdu) {
		this.jingdu = jingdu;
	}

	@Column(name = "weidu", precision = 10, scale = 6)
	public Double getWeidu() {
		return this.weidu;
	}

	public void setWeidu(Double weidu) {
		this.weidu = weidu;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}