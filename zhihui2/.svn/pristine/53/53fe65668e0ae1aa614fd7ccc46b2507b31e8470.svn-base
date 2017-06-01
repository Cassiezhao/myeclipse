package chris.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Youkem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "youkem", catalog = "zhineng")
public class Youkem implements java.io.Serializable {

	// Fields

	private Integer youkeMid;
	private Integer youkeMle;
	private Integer youkeMbr;
	private Integer youkeMboom;
	private String systemtel;
	@Column(name="systemtel")
	public String getSystemtel() {
		return systemtel;
	}

	public void setSystemtel(String systemtel) {
		this.systemtel = systemtel;
	}

	// Constructors
	@Column(name = "youkeMboom")
	public Integer getYoukeMboom() {
		return youkeMboom;
	}

	public void setYoukeMboom(Integer youkeMboom) {
		this.youkeMboom = youkeMboom;
	}

	/** default constructor */
	public Youkem() {
	}

	/** full constructor */
	public Youkem(Integer youkeMle, Integer youkeMbr) {
		this.youkeMle = youkeMle;
		this.youkeMbr = youkeMbr;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "youkeMid", unique = true, nullable = false)
	public Integer getYoukeMid() {
		return this.youkeMid;
	}

	public void setYoukeMid(Integer youkeMid) {
		this.youkeMid = youkeMid;
	}

	@Column(name = "youkeMle")
	public Integer getYoukeMle() {
		return this.youkeMle;
	}

	public void setYoukeMle(Integer youkeMle) {
		this.youkeMle = youkeMle;
	}

	@Column(name = "youkeMbr")
	public Integer getYoukeMbr() {
		return this.youkeMbr;
	}

	public void setYoukeMbr(Integer youkeMbr) {
		this.youkeMbr = youkeMbr;
	}

}