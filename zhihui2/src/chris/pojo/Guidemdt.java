package chris.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Guidemdt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guidemdt", catalog = "zhineng")
public class Guidemdt implements java.io.Serializable {

	// Fields

	private Integer detaid;
	private Timestamp brot;
	private Timestamp rett;
	private String sutinfo;

	private String guidemid;

	// Constructors
	@Column(name = "guidemid")
	public String getGuidemid() {
		return guidemid;
	}

	public void setGuidemid(String guidemid) {
		this.guidemid = guidemid;
	}

	/** default constructor */
	public Guidemdt() {
	}

	/** full constructor */
	public Guidemdt(Timestamp brot, Timestamp rett, String sutinfo) {
		this.brot = brot;
		this.rett = rett;
		this.sutinfo = sutinfo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "detaid", unique = true, nullable = false)
	public Integer getDetaid() {
		return this.detaid;
	}

	public void setDetaid(Integer detaid) {
		this.detaid = detaid;
	}

	@Column(name = "brot", length = 19)
	public Timestamp getBrot() {
		return this.brot;
	}

	public void setBrot(Timestamp brot) {
		this.brot = brot;
	}

	@Column(name = "rett", length = 19)
	public Timestamp getRett() {
		return this.rett;
	}

	public void setRett(Timestamp rett) {
		this.rett = rett;
	}

	@Column(name = "sutinfo", length = 50)
	public String getSutinfo() {
		return this.sutinfo;
	}

	public void setSutinfo(String sutinfo) {
		this.sutinfo = sutinfo;
	}

}